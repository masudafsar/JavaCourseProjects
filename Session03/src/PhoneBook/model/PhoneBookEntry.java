package PhoneBook.model;

import PhoneBook.utils.WordUtils;

public class PhoneBookEntry {
    private String title;
    private String phone;

    @Override
    public String toString() {
        return title + "\t\t\t\t (" + phone + ")";
    }

    public void setTitle(String title) {
        this.title = WordUtils.convertToTitleCase(title);
    }

    public String getTitle() {
        return title;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhone(int phone) {
        this.phone = "0" + phone;
    }

    public String getPhone() {
        return phone;
    }


}
