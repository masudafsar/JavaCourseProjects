package PhoneBook.model;

public class PhoneBookBusinessEntry extends PhoneBookEntry {
    public PhoneBookBusinessEntry(String title, String phone) {
        super(title, phone, PhoneBookEntryType.BUSINESS);
    }
}
