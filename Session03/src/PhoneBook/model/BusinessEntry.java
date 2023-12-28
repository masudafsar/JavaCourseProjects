package PhoneBook.model;

public class BusinessEntry extends Entry {
    private String fax;

    public BusinessEntry(String name, String phone) {
        super(name, phone, EntryType.BUSINESS);
    }

    @Override
    public String toString() {
        var str = new StringBuilder();
        str.append(String.format("Name: %s\n", this.getName()));
        str.append(String.format("Phone: %s\n", this.getPhone()));
        str.append(String.format("Fax: %s\n", this.getFax()));
        str.append(String.format("Type: %s", this.getType()));
        return str.toString();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
