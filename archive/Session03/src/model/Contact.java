package model;

import utils.WordUtils;

import java.util.ArrayList;

public abstract class Contact {
    private static int nextId = 0;

    private final int id;
    private String name;
    private ArrayList<Entry> phones;

    private final ContactType type;

    public Contact(String name, ArrayList<Entry> phones, ContactType type) {
        this.id = ++nextId;
        this.setName(name);
        this.setPhones(phones);
        this.type = type;
    }

    @Override
    abstract public String toString();

    public boolean isContained(String str) {
        return this.toString().toLowerCase().contains(str.toLowerCase());
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

    public ArrayList<Entry> getPhones() {
        return this.phones;
    }

    public ContactType getType() {
        return this.type;
    }

    public String toStringPhones() {
        if (this.phones == null)
            return "Empty";
        var str = new StringBuilder();
        for (var phone : this.phones) {
            str.append(String.format(" - %s\n", phone));
        }
        return str.toString();
    }
}
