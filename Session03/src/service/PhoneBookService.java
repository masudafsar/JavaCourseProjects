package service;

import model.BusinessEntry;
import model.Entry;
import model.PersonalEntry;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class PhoneBookService {
    private final ArrayList<Entry> entries;

    public PhoneBookService() {
        this.entries = new ArrayList<>();
    }

    public void appendPersonal(String name, String family, String phone) {
        this.entries.add(new PersonalEntry(name, family, phone));
    }

    public void appendBusiness(String name, String phone, String fax) {
        this.entries.add(new BusinessEntry(name, phone, fax));
    }

    public ArrayList<Entry> filterEntries(String query) {
        var filtered =  this.entries.stream().filter(entry -> entry.isContained(query)).toList();
        return new ArrayList<Entry>(filtered);
    }

    public ArrayList<Entry> getEntries() {
        return entries;
    }
}
