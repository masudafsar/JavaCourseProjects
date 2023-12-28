package PhoneBook.model;

public class BusinessEntry extends Entry {
    private String fax;

    public BusinessEntry(String name, String phone) {
        super(name, phone, EntryType.BUSINESS);
    }

    @Override
    public String toString() {
        return String.format("Name: %s\n", this.getName()) +
                String.format("Phone: %s\n", this.getPhone()) +
                String.format("Fax: %s\n", this.getFax()) +
                String.format("Type: %s", this.getType());
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
