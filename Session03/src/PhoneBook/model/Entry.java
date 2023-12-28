package PhoneBook.model;

import PhoneBook.utils.WordUtils;

public class Entry {
    private String name;
    private String phone;

    private final EntryType type;

    public Entry(String name, String phone, EntryType type) {
        this.setName(name);
        this.setPhone(phone);
        this.type = type;
    }

    @Override
    public String toString() {
        var str = new StringBuilder();
        str.append(String.format("Name: %s\n", this.getName()));
        str.append(String.format("Phone: %s\n", this.getPhone()));
        str.append(String.format("Type: %s\n", this.getType()));
        return str.toString();
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
