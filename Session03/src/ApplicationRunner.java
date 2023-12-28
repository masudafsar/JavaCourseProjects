import service.PhoneBookService;

import java.util.Scanner;

public class ApplicationRunner {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        var phoneBook = new PhoneBookService(scanner);
        phoneBook.run();

        scanner.close();
    }
}
