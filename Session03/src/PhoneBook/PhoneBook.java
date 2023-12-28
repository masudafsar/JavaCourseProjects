package PhoneBook;

import PhoneBook.model.BusinessEntry;
import PhoneBook.model.Entry;
import PhoneBook.model.EntryType;
import PhoneBook.model.PersonalEntry;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        var entries = new ArrayList<Entry>();
        var scanner = new Scanner(System.in);

        runPhoneBookManager(entries, scanner);

        scanner.close();
    }

    private static void runPhoneBookManager(ArrayList<Entry> entries, Scanner scanner) {
        System.out.println("Welcome to Phone Book application.");

        mainLoop:
        while (true) {
            String command = getCommand(scanner);

            switch (command) {
                case "a":
                    addContactEntry(entries, scanner);
                    break;
                case "l":
                    showAllEntries(entries);
                    break;
                case "q":
                    break mainLoop;
                default:
                    System.out.println("Invalid command, try again.");
                    break;
            }
        }

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

    private static void showAllEntries(ArrayList<Entry> entries) {
        System.out.println("\n----- List of entries -----");
        for (Entry entry : entries) {
            System.out.println(entry);
            System.out.println("---------------------------");
        }
    }

    private static void addContactEntry(ArrayList<Entry> entries, Scanner scanner) {
        System.out.println("------ Add new entry ------");
        var type = getContactType(scanner);
        if (type == null) return; // exit from adding contact

        switch (type) {
            case PERSONAL -> {
                addPersonalContactEntry(entries, scanner);
            }
            case BUSINESS -> {
                addBusinessContactEntry(entries, scanner);
            }
        }
    }

    private static void addBusinessContactEntry(ArrayList<Entry> entries, Scanner scanner) {
        System.out.println("Enter name:");
        System.out.print("$> ");
        var name = scanner.nextLine();

        System.out.println("Enter phone number:");
        System.out.print("$> ");
        var phone = scanner.nextLine();

        System.out.println("Enter fax number:");
        System.out.print("$> ");
        var fax = scanner.nextLine();

        var entry = new BusinessEntry(name, phone);
        entry.setFax(fax);
        entries.add(entry);
        System.out.println("Added:\n" + entry);
    }

    private static void addPersonalContactEntry(ArrayList<Entry> entries, Scanner scanner) {
        System.out.println("Enter name:");
        System.out.print("$> ");
        var name = scanner.nextLine();

        System.out.println("Enter family:");
        System.out.print("$> ");
        var family = scanner.nextLine();

        System.out.println("Enter phone number:");
        System.out.print("$> ");
        var phone = scanner.nextLine();

        var entry = new PersonalEntry(name, phone);
        entry.setFamily(family);
        entries.add(entry);
        System.out.println("Added:\n" + entry);
    }

    private static EntryType getContactType(Scanner scanner) {
        while (true) {
            System.out.println("Please enter type of contact type:");
            System.out.println(" - p        Personal type");
            System.out.println(" - b        Business type");
            System.out.println(" - x        Exit from contact adding.");
            System.out.print("$> ");

            String command = scanner.nextLine();

            switch (command) {
                case "p" -> {
                    return EntryType.PERSONAL;
                }
                case "b" -> {
                    return EntryType.BUSINESS;
                }
                case "x" -> {
                    return null;
                }
                default -> System.out.println("Invalid command, try again.");
            }
        }
    }
}
