package PhoneBook;

import PhoneBook.model.PhoneBookEntry;
import PhoneBook.model.PhoneBookPersonalEntry;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        var entries = new ArrayList<PhoneBookEntry>();
        var scanner = new Scanner(System.in);

        runPhoneBookManager(entries, scanner);

        scanner.close();
    }

    private static void runPhoneBookManager(ArrayList<PhoneBookEntry> entries, Scanner scanner) {
        System.out.println("Welcome to Phone Book application.");

        String command;
        do {
            command = getCommand(scanner);

            switch (command) {
                case "a":
                    addContactEntry(entries, scanner);
                    break;
                case "l":
                    showAllEntries(entries);
                    break;
                default:
                    System.out.println("Invalid command, try again.");
                    break;
            }
        } while (!command.equals("q"));

        System.out.println("Have a nice day...");
    }

    private static String getCommand(Scanner scanner) {
        System.out.println("\nPlease enter a command to continue:");
        System.out.println("valid commands:");
        System.out.println(" - a        Add new entry");
        System.out.println(" - l        List of all entries");
        System.out.println(" - q        Quit");
        System.out.print("$> ");

        return scanner.nextLine();
    }

    private static void showAllEntries(ArrayList<PhoneBookEntry> entries) {
        System.out.println("\n----- List of entries -----");
        for (PhoneBookEntry entry : entries) {
            System.out.println(entry);
            System.out.println("---------------------------");
        }
    }

    private static void addContactEntry(ArrayList<PhoneBookEntry> entries, Scanner scanner) {
        System.out.println("\n------ Add new entry ------");
        System.out.println("Enter title of contact:");
        var title = scanner.nextLine();
        System.out.println("Enter phone of contact:");
        var phone = scanner.nextLine();

        var entry = new PhoneBookPersonalEntry(title, phone);
        System.out.println("Added:\n" + entry);
        entries.add(entry);
    }
}
