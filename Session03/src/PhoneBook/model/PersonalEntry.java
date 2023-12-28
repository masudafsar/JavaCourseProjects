package PhoneBook.model;

import PhoneBook.utils.WordUtils;

public class PersonalEntry extends Entry {
    private String family;

    public PersonalEntry(String name, String phone) {
        super(name, phone, EntryType.PERSONAL);
    }

    @Override
    public String toString() {
        var str = new StringBuilder();
        str.append(String.format("Name: %s\n", this.getName()));
        str.append(String.format("Family: %s\n", this.getFamily()));
        str.append(String.format("Phone: %s\n", this.getPhone()));
        str.append(String.format("Type: %s", this.getType()));
        return str.toString();
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = WordUtils.convertToTitleCase(family);
    }
}
