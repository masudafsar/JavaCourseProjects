package service;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBookService {
    private final HashMap<Integer, Contact> contacts;

    public PhoneBookService() {
        this.contacts = new HashMap<>();
        this.seedPhoneBook();
    }

    public void seedPhoneBook() {
        Contact contact = new PersonalContact("john", "doe", new ArrayList<>(Arrays.asList(
                new Entry(EntryType.HOME, "0213334567"),
                new Entry(EntryType.MOBILE, "09123456789")
        )));
        this.contacts.put(contact.getId(), contact);

        contact = new PersonalContact("jean", "doe",  new ArrayList<>(Arrays.asList(
                new Entry(EntryType.HOME, "01234567890"),
                new Entry(EntryType.MOBILE, "09876543210")
        )));
        this.contacts.put(contact.getId(), contact);

        contact = new BusinessContact("Apple", "www.apple.com",  new ArrayList<>(Arrays.asList(
                new Entry(EntryType.WORK, "+12345678900"),
                new Entry(EntryType.FAX, "+12345678900")
        )));
        this.contacts.put(contact.getId(), contact);
    }

    public void appendPersonal(String name, String family, ArrayList<Entry> entries) {
        var contact = new PersonalContact(name, family, entries);
        this.contacts.put(contact.getId(), contact);
    }

    public void appendBusiness(String name, String website, ArrayList<Entry> entries) {
        var contact = new BusinessContact(name, website, entries);
        this.contacts.put(contact.getId(), contact);
    }

    public HashMap<Integer, Contact> filterContacts(String query) {
        var filtered = this.contacts
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().searchBy(query))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new HashMap<>(filtered);
    }

    public Contact findById(int id) {
        return this.contacts.get(id);
    }

    public void editPersonal(int id, String name, String family, ArrayList<Entry> entries) {
        var contact = (PersonalContact) this.contacts.get(id);
        contact.setName(name);
        contact.setFamily(family);
        contact.setPhones(entries);
    }

    public void editBusiness(int id, String name, String website, ArrayList<Entry> entries) {
        var contact = (BusinessContact) this.contacts.get(id);
        contact.setName(name);
        contact.setWebsite(website);
        contact.setPhones(entries);
    }

    public void remove(int id) {
        this.contacts.remove(id);
    }

    public HashMap<Integer, Contact> getContacts() {
        return contacts;
    }
}
