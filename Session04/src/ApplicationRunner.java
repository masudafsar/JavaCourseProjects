import application.PhoneBookApplication;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (var phoneBook = new PhoneBookApplication()) {
            phoneBook.run();
        }
    }
}
