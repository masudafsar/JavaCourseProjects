package model;

import utils.WordUtils;

public class PersonalEntry extends Entry {
    private String family;

    public PersonalEntry(String name, String family, String phone) {
        super(name, phone, EntryType.PERSONAL);
        this.setFamily(family);
    }

    @Override
    public String toString() {
        return String.format("Name: %s\n", this.getName()) +
                String.format("Family: %s\n", this.getFamily()) +
                String.format("Phone: %s\n", this.getPhone()) +
                String.format("Type: %s", this.getType());
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = WordUtils.convertToTitleCase(family);
    }
}
