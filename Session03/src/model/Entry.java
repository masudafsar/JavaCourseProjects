package model;

import utils.WordUtils;

public abstract class Entry {
    private static int nextId = 0;

    private final int id;
    private String name;
    private String phone;

    private final EntryType type;

    public Entry(String name, String phone, EntryType type) {
        this.id = ++nextId;
        this.setName(name);
        this.setPhone(phone);
        this.type = type;
    }

    @Override
    abstract public String toString();

    abstract public boolean isContained(String str);

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = WordUtils.convertToTitleCase(name);
    }

    public String getName() {
        return name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public EntryType getType() {
        return type;
    }
}
