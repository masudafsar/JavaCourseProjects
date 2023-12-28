package PhoneBook.model;

public class PersonalEntry extends Entry {
    public PersonalEntry(String title, String phone) {
        super(title, phone, EntryType.PERSONAL);
    }
}
