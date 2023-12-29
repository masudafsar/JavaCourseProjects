package service;

import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBookService {
    private final HashMap<Integer, Entry> entries;

    public PhoneBookService() {
        this.entries = new HashMap<>();
        this.seedPhoneBook();
    }

    public void seedPhoneBook() {
        Entry entry = new PersonalEntry("john", "doe", new ArrayList<>(Arrays.asList(
                new Phone(PhoneType.HOME, "0213334567"),
                new Phone(PhoneType.MOBILE, "09123456789")
        )));
        this.entries.put(entry.getId(), entry);

        entry = new PersonalEntry("jean", "doe",  new ArrayList<>(Arrays.asList(
                new Phone(PhoneType.HOME, "01234567890"),
                new Phone(PhoneType.MOBILE, "09876543210")
        )));
        this.entries.put(entry.getId(), entry);

        entry = new BusinessEntry("Apple", "www.apple.com",  new ArrayList<>(Arrays.asList(
                new Phone(PhoneType.WORK, "+12345678900"),
                new Phone(PhoneType.FAX, "+12345678900")
        )));
        this.entries.put(entry.getId(), entry);
    }

    public void appendPersonal(String name, String family, ArrayList<Phone> phones) {
        var entry = new PersonalEntry(name, family, phones);
        this.entries.put(entry.getId(), entry);
    }

    public void appendBusiness(String name, String website, ArrayList<Phone> phones) {
        var entry = new BusinessEntry(name, website, phones);
        this.entries.put(entry.getId(), entry);
    }

    public HashMap<Integer, Entry> filterEntries(String query) {
        var filtered = this.entries
                .entrySet()
                .stream()
                .filter(mapEntry -> mapEntry.getValue().isContained(query))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        return new HashMap<>(filtered);
    }

    public Entry findById(int id) {
        return this.entries.get(id);
    }

    public void editPersonal(int id, String name, String family, ArrayList<Phone> phones) {
        var entry = (PersonalEntry) this.entries.get(id);
        entry.setName(name);
        entry.setFamily(family);
        entry.setPhones(phones);
    }

    public void editBusiness(int id, String name, String website, ArrayList<Phone> phones) {
        var entry = (BusinessEntry) this.entries.get(id);
        entry.setName(name);
        entry.setWebsite(website);
        entry.setPhones(phones);
    }

    public void remove(int id) {
        this.entries.remove(id);
    }

    public HashMap<Integer, Entry> getEntries() {
        return entries;
    }
}
