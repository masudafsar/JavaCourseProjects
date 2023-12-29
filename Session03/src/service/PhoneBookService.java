package service;

import model.BusinessEntry;
import model.Entry;
import model.PersonalEntry;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PhoneBookService {
    private final HashMap<Integer, Entry> entries;

    public PhoneBookService() {
        this.entries = new HashMap<>();
        this.seedPhoneBook();
    }

    public void seedPhoneBook(){
        var entry = new PersonalEntry("john", "doe", "09123456789");
        this.entries.put(entry.getId(), entry);

        entry = new PersonalEntry("jean", "doe", "09876543210");
        this.entries.put(entry.getId(), entry);

        entry = new PersonalEntry("foo", "bar", "01122334455");
        this.entries.put(entry.getId(), entry);
    }

    public void appendPersonal(String name, String family, String phone) {
        var entry = new PersonalEntry(name, family, phone);
        this.entries.put(entry.getId(), entry);
    }

    public void appendBusiness(String name, String phone, String fax) {
        var entry = new BusinessEntry(name, phone, fax);
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

    public void removeEntry(int id) {
        this.entries.remove(id);
    }

    public HashMap<Integer, Entry> getEntries() {
        return entries;
    }
}
