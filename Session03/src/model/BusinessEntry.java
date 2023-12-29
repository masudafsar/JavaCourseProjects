package model;

import java.util.ArrayList;

public class BusinessEntry extends Entry {
    private String website;

    public BusinessEntry(String name, String website, ArrayList<Phone> phones) {
        super(name, phones, EntryType.BUSINESS);
        this.setWebsite(website);
    }

    @Override
    public String toString() {
        return String.format("(%s) [%s]\n", this.getId(), this.getType()) +
                String.format("%s (%s)\n", this.getName(), this.getWebsite()) +
                this.toStringPhones();
    }

    public String getWebsite() {
        return this.website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
