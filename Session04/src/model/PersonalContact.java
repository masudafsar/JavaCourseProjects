package model;

import utils.WordUtils;

import java.util.ArrayList;

public class PersonalContact extends Contact {
    private String family;

    public PersonalContact(String name, String family, ArrayList<Entry> phones) {
        super(name, phones, ContactType.PERSONAL);
        this.setFamily(family);
    }

    @Override
    public String toString() {
        return String.format("(%s) [%s]\n", this.getId(), this.getType()) +
                String.format("%s %s\n", this.getName(), this.getFamily()) +
                this.toStringPhones();
    }

    @Override
    public boolean searchBy(String query) {
        var result = super.searchBy(query);
        result = result || this.getFamily().toLowerCase().contains(query.toLowerCase());
        return result;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = WordUtils.convertToTitleCase(family);
    }
}
