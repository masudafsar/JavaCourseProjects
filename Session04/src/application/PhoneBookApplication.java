package application;

import model.*;
import service.PhoneBookService;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBookApplication {
    private final Scanner scanner;
    private final PhoneBookService phoneBookService;

    public PhoneBookApplication() {
        this.scanner = new Scanner(System.in);
        this.phoneBookService = new PhoneBookService();
    }

    public void run() {
        System.out.println("Welcome to Phone Book application.");

        mainLoop:
        while (true) {
            String command = this.getCommand();

            switch (command) {
                case "q":
                    break mainLoop;
                case "a":
                    this.addContact();
                    break;
                case "l":
                    this.showAllContactEntries();
                    break;
                case "s":
                    this.searchInContact();
                    break;
                case "e":
                    this.editContact();
                    break;
                case "r":
                    this.removeContact();
                    break;
                default:
                    System.out.println("Invalid command, try again.");
                    break;
            }
        }

        scanner.close();
        System.out.println("Have a nice day...");
    }

    private String getCommand() {
        System.out.println("\nPlease enter a command to continue:");
        System.out.println("valid commands:");
        System.out.println(" - a        Add new contact");
        System.out.println(" - l        List of all contacts");
        System.out.println(" - s        Search in contacts");
        System.out.println(" - e        Edit contact by id");
        System.out.println(" - r        Remove contact by id");
        System.out.println(" - q        Quit");
        System.out.print("$> ");

        return this.scanner.nextLine();
    }

    private void addContact() {
        System.out.println("------ Add new contact ------");
        var type = this.getContactType();
        if (type == null) return; // exit from adding contact

        switch (type) {
            case PERSONAL -> this.addPersonalContact();
            case BUSINESS -> this.addBusinessContact();
        }
    }

    private ContactType getContactType() {
        while (true) {
            System.out.println("Please enter type of contact type:");
            System.out.println(" - p        Personal type");
            System.out.println(" - b        Business type");
            System.out.println(" - x        Back to application menu.");
            System.out.print("$> ");

            String command = this.scanner.nextLine();

            switch (command) {
                case "p" -> {
                    return ContactType.PERSONAL;
                }
                case "b" -> {
                    return ContactType.BUSINESS;
                }
                case "x" -> {
                    return null;
                }
                default -> System.out.println("Invalid command, try again.");
            }
        }
    }

    private void addPersonalContact() {
        System.out.println("Enter name:");
        System.out.print("$> ");
        var name = this.scanner.nextLine();

        System.out.println("Enter family:");
        System.out.print("$> ");
        var family = this.scanner.nextLine();

        var entries = getEntriesList();

        this.phoneBookService.appendPersonal(name, family, entries);
    }

    private void addBusinessContact() {
        System.out.println("Enter name:");
        System.out.print("$> ");
        var name = this.scanner.nextLine();

        System.out.println("Enter website:");
        System.out.print("$> ");
        var website = this.scanner.nextLine();

        var entries = getEntriesList();

        this.phoneBookService.appendBusiness(name, website, entries);
    }

    private void showAllContactEntries() {
        if (this.phoneBookService.getContacts().isEmpty()) {
            System.out.println("---------------------------");
            System.out.println("-   PhoneBook is empty!   -");
            System.out.println("---------------------------");
            return;
        }
        System.out.println("\n----- List of contacts -----");
        for (Contact contact : this.phoneBookService.getContacts().values()) {
            System.out.println(contact);
            System.out.println("---------------------------");
        }
    }

    private void searchInContact() {
        System.out.println("\n----- Search in contacts -----");
        System.out.println("Enter query:");
        System.out.print("$> ");
        var query = this.scanner.nextLine();

        var filteredContacts = this.phoneBookService.filterContacts(query);

        if (filteredContacts.isEmpty()) {
            System.out.println("---------------------------");
            System.out.println("-   Not found any contact  -");
            System.out.println("---------------------------");
            return;
        }
        System.out.println("\n----- Filtered contacts -----");
        for (Contact contact : filteredContacts.values()) {
            System.out.println(contact);
            System.out.println("---------------------------");
        }
    }

    private void editContact() {
        var contact = getContactById();
        if (contact == null) return;

        System.out.println(contact);
        System.out.println("Are you sure? (y/n)");

        var answer = this.scanner.nextLine();

        if (answer.equals("y")) {
            System.out.println("------ Edit contact ------");
            var type = this.getContactType();
            if (type == null) return; // exit from editing contact

            switch (type) {
                case PERSONAL -> this.editPersonalContact((PersonalContact) contact);
                case BUSINESS -> this.editBusinessContact((BusinessContact) contact);
            }

            System.out.println("Updated successfully.");
        }
    }

    private void editPersonalContact(PersonalContact contact) {
        System.out.printf("Enter name: (%s)%n", contact.getName());
        System.out.print("$> ");
        var name = this.scanner.nextLine();

        System.out.printf("Enter family: (%s)%n", contact.getFamily());
        System.out.print("$> ");
        var family = this.scanner.nextLine();

        var entries = getEntriesList();

        this.phoneBookService.editPersonal(contact.getId(), name, family, entries);
    }

    private void editBusinessContact(BusinessContact contact) {
        System.out.printf("Enter name: (%s)%n", contact.getName());
        System.out.print("$> ");
        var name = this.scanner.nextLine();

        System.out.printf("Enter website: (%s)%n", contact.getWebsite());
        System.out.print("$> ");
        var website = this.scanner.nextLine();

        var entries = getEntriesList();

        this.phoneBookService.editBusiness(contact.getId(), name, website, entries);
    }

    private void removeContact() {
        var contact = getContactById();
        if (contact == null) return;

        System.out.println(contact);
        System.out.println("Are you sure? (y/n)");

        var answer = this.scanner.nextLine();

        if (answer.equals("y")) {
            this.phoneBookService.remove(contact.getId());
            System.out.println("Removed successfully.");
        }
    }

    private Contact getContactById() {
        System.out.println("Enter contact's id:");
        System.out.print("$> ");
        var id = this.scanner.nextLine();

        try {
            var contact = this.phoneBookService.findById(Integer.parseInt(id));
            if (contact == null) {
                System.out.println("Not found any contact.");
            }
            return contact;
        } catch (NumberFormatException e) {
            System.out.println("Invalid Id.");
        }
        return null;
    }

    private EntryType getEntryType() {
        while (true) {
            System.out.println("Please enter type of phone:");
            System.out.println(" - m        Mobile");
            System.out.println(" - h        Home");
            System.out.println(" - w        Work");
            System.out.println(" - f        Fax");
            System.out.print("$> ");

            String command = this.scanner.nextLine();

            switch (command) {
                case "m" -> {
                    return EntryType.MOBILE;
                }
                case "h" -> {
                    return EntryType.HOME;
                }
                case "w" -> {
                    return EntryType.WORK;
                }
                case "f" -> {
                    return EntryType.FAX;
                }
                default -> System.out.println("Invalid command, try again.");
            }
        }
    }

    private ArrayList<Entry> getEntriesList() {
        var entries = new ArrayList<Entry>();

        while (true) {
            var entryType = getEntryType();

            System.out.println("Please phone number:");
            System.out.print("$> ");
            var entryValue = this.scanner.nextLine();

            entries.add(new Entry(entryType, entryValue));

            System.out.println("Add more? (y/n)");
            System.out.print("$> ");
            var answer = this.scanner.nextLine();

            if (!answer.equals("y")) {
                break;
            }
        }

        return entries;
    }
}
