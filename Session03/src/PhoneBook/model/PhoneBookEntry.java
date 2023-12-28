package PhoneBook.model;

import PhoneBook.utils.WordUtils;

public class PhoneBookEntry {
    private String title;
    private String phone;

    private final PhoneBookEntryType type;

    public PhoneBookEntry(String title, String phone, PhoneBookEntryType type) {
        this.setTitle(title);
        this.setPhone(phone);
        this.type = type;
    }

    @Override
    public String toString() {
        var str = new StringBuilder();
        str.append(String.format("Title: %s\n", this.title));
        str.append(String.format("Phone: %s\n", this.phone));
        str.append(String.format("Type: %s\n", this.type));
        return str.toString();
    }

    public void setTitle(String title) {
        this.title = WordUtils.convertToTitleCase(title);
    }

    public String getTitle() {
        return title;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhone(int phone) {
        this.phone = "0" + phone;
    }

    public String getPhone() {
        return phone;
    }

    public PhoneBookEntryType getType() {
        return type;
    }
}
