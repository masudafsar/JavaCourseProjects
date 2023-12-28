package PhoneBook.model;

public class BusinessEntry extends Entry {
    public BusinessEntry(String title, String phone) {
        super(title, phone, EntryType.BUSINESS);
    }
}
