package model;

import utils.WordUtils;

import java.util.ArrayList;

public class PersonalEntry extends Entry {
    private String family;

    public PersonalEntry(String name, String family, ArrayList<Phone> phones) {
        super(name, phones, EntryType.PERSONAL);
        this.setFamily(family);
    }

    @Override
    public String toString() {
        return String.format("(%s) [%s]\n", this.getId(), this.getType()) +
                String.format("%s %s\n", this.getName(), this.getFamily()) +
                this.toStringPhones();
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = WordUtils.convertToTitleCase(family);
    }
}
