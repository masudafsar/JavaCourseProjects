package service;

import model.BusinessEntry;
import model.Entry;
import model.EntryType;
import model.PersonalEntry;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookService {
    private final Scanner scanner;

    private final ArrayList<Entry> entries;

    public PhoneBookService(Scanner scanner) {
        this.scanner = scanner;
        this.entries = new ArrayList<>();
    }

    public void run() {
        System.out.println("Welcome to Phone Book application.");

        mainLoop:
        while (true) {
            String command = this.getCommand();

            switch (command) {
                case "a":
                    this.addContactEntry();
                    break;
                case "l":
                    this.showAllEntries();
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

    private String getCommand() {
        System.out.println("\nPlease enter a command to continue:");
        System.out.println("valid commands:");
        System.out.println(" - a        Add new entry");
        System.out.println(" - l        List of all entries");
        System.out.println(" - q        Quit");
        System.out.print("$> ");

        return this.scanner.nextLine();
    }

    private void addContactEntry() {
        System.out.println("------ Add new entry ------");
        var type = this.getContactType();
        if (type == null) return; // exit from adding contact

        switch (type) {
            case PERSONAL -> this.addPersonalContactEntry();
            case BUSINESS -> this.addBusinessContactEntry();
        }
    }

    private EntryType getContactType() {
        while (true) {
            System.out.println("Please enter type of contact type:");
            System.out.println(" - p        Personal type");
            System.out.println(" - b        Business type");
            System.out.println(" - x        Exit from contact adding.");
            System.out.print("$> ");

            String command = this.scanner.nextLine();

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

    private void addPersonalContactEntry() {
        System.out.println("Enter name:");
        System.out.print("$> ");
        var name = this.scanner.nextLine();

        System.out.println("Enter family:");
        System.out.print("$> ");
        var family = this.scanner.nextLine();

        System.out.println("Enter phone number:");
        System.out.print("$> ");
        var phone = this.scanner.nextLine();

        var entry = new PersonalEntry(name, phone);
        entry.setFamily(family);
        this.entries.add(entry);
        System.out.println("Added:\n" + entry);
    }

    private void addBusinessContactEntry() {
        System.out.println("Enter name:");
        System.out.print("$> ");
        var name = this.scanner.nextLine();

        System.out.println("Enter phone number:");
        System.out.print("$> ");
        var phone = this.scanner.nextLine();

        System.out.println("Enter fax number:");
        System.out.print("$> ");
        var fax = this.scanner.nextLine();

        var entry = new BusinessEntry(name, phone);
        entry.setFax(fax);
        this.entries.add(entry);
        System.out.println("Added:\n" + entry);
    }

    private void showAllEntries() {
        System.out.println("\n----- List of entries -----");
        for (Entry entry : this.entries) {
            System.out.println(entry);
            System.out.println("---------------------------");
        }
    }
}
