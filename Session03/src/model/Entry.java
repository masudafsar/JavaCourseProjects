package model;

import utils.WordUtils;

import java.util.ArrayList;

public abstract class Entry {
    private static int nextId = 0;

    private final int id;
    private String name;
    private ArrayList<Phone> phones;

    private final EntryType type;

    public Entry(String name, ArrayList<Phone> phones, EntryType type) {
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

    public void setPhones(ArrayList<Phone> phones) {
        this.phones = phones;
    }

    public ArrayList<Phone> getPhones() {
        return this.phones;
    }

    public EntryType getType() {
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
