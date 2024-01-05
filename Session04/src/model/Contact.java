package model;

import utils.WordUtils;

import java.util.ArrayList;

public abstract class Contact implements Searchable {
    private static int nextId = 0;
    private final int id;
    private final ContactType type;
    private String name;
    private ArrayList<Entry> phones;

    public Contact(String name, ArrayList<Entry> phones, ContactType type) {
        this.id = ++nextId;
        this.setName(name);
        this.setPhones(phones);
        this.type = type;
    }

    @Override
    abstract public String toString();

    @Override
    public boolean searchBy(String query) {
        var result = this.getName().toLowerCase().contains(query.toLowerCase());

        for (var phone : this.phones) {
            if (result) break;
            result = phone.getValue().toLowerCase().contains(query.toLowerCase());
        }

        return result;
    }

    public int getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = WordUtils.convertToTitleCase(name);
    }

    public String getName() {
        return this.name;
    }

    public void setPhones(ArrayList<Entry> phones) {
        this.phones = phones;
    }

    public ContactType getType() {
        return this.type;
    }

    public String toStringPhones() {
        if (this.phones == null || this.phones.isEmpty())
            return "Empty";
        var phoneStrArray = this.phones.stream().map(phone -> String.format(" - %s", phone)).toList();
        return String.join("\n", phoneStrArray);
    }
}
