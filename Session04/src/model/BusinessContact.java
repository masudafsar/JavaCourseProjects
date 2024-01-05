package model;

import java.util.ArrayList;

public class BusinessContact extends Contact {
    private String website;

    public BusinessContact(String name, String website, ArrayList<Entry> phones) {
        super(name, phones, ContactType.BUSINESS);
        this.setWebsite(website);
    }

    @Override
    public String toString() {
        return String.format("(%s) [%s]\n", this.getId(), this.getType()) +
                String.format("%s (%s)\n", this.getName(), this.getWebsite()) +
                this.toStringPhones();
    }

    @Override
    public boolean searchBy(String searchBy) {
        var result = super.searchBy(searchBy);
        result = result || this.getWebsite().toLowerCase().contains(searchBy.toLowerCase());
        return result;
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
