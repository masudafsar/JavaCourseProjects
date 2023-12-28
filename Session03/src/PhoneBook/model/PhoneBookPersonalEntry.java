package PhoneBook.model;

public class PhoneBookPersonalEntry extends PhoneBookEntry {
    public PhoneBookPersonalEntry(String title, String phone) {
        super(title, phone, PhoneBookEntryType.PERSONAL);
    }
}
