package PhoneBook.model;

import PhoneBook.utils.WordUtils;

public abstract class Entry {
    private String name;
    private String phone;

    private final EntryType type;

    public Entry(String name, String phone, EntryType type) {
        this.setName(name);
        this.setPhone(phone);
        this.type = type;
    }

    @Override
    abstract public String toString();

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
