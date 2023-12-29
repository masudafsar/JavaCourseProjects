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
                    this.addContactEntry();
                    break;
                case "l":
                    this.showAllContactEntries();
                    break;
                case "s":
                    this.searchInContactEntries();
                    break;
                case "e":
                    this.editContactEntry();
                    break;
                case "r":
                    this.removeContactEntry();
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
        System.out.println(" - a        Add new entry");
        System.out.println(" - l        List of all entries");
        System.out.println(" - s        Search in entries");
        System.out.println(" - e        Edit entry by id");
        System.out.println(" - r        Remove entry by id");
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
            System.out.println(" - x        Back to application menu.");
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

        var phones = getPhoneList();

        this.phoneBookService.appendPersonal(name, family, phones);
    }

    private void addBusinessContactEntry() {
        System.out.println("Enter name:");
        System.out.print("$> ");
        var name = this.scanner.nextLine();

        System.out.println("Enter website:");
        System.out.print("$> ");
        var website = this.scanner.nextLine();

        var phones = getPhoneList();

        this.phoneBookService.appendBusiness(name, website, phones);
    }

    private void showAllContactEntries() {
        if (this.phoneBookService.getEntries().isEmpty()) {
            System.out.println("---------------------------");
            System.out.println("-   PhoneBook is empty!   -");
            System.out.println("---------------------------");
            return;
        }
        System.out.println("\n----- List of entries -----");
        for (Entry entry : this.phoneBookService.getEntries().values()) {
            System.out.println(entry);
            System.out.println("---------------------------");
        }
    }

    private void searchInContactEntries() {
        System.out.println("\n----- Search in entries -----");
        System.out.println("Enter query:");
        System.out.print("$> ");
        var query = this.scanner.nextLine();

        var filteredEntries = this.phoneBookService.filterEntries(query);

        if (filteredEntries.isEmpty()) {
            System.out.println("---------------------------");
            System.out.println("-   Not found any entry   -");
            System.out.println("---------------------------");
            return;
        }
        System.out.println("\n----- Filtered entries -----");
        for (Entry entry : filteredEntries.values()) {
            System.out.println(entry);
            System.out.println("---------------------------");
        }
    }

    private void editContactEntry() {
        var entry = getContactEntryById();
        if (entry == null) return;

        System.out.println(entry);
        System.out.println("Are you sure? (y/n)");

        var answer = this.scanner.nextLine();

        if (answer.equals("y")) {
            System.out.println("------ Edit entry ------");
            var type = this.getContactType();
            if (type == null) return; // exit from editing contact

            switch (type) {
                case PERSONAL -> this.editPersonalContactEntry((PersonalEntry) entry);
                case BUSINESS -> this.editBusinessContactEntry((BusinessEntry) entry);
            }

            System.out.println("Updated successfully.");
        }
    }

    private void editPersonalContactEntry(PersonalEntry entry) {
        System.out.printf("Enter name: (%s)%n", entry.getName());
        System.out.print("$> ");
        var name = this.scanner.nextLine();

        System.out.printf("Enter family: (%s)%n", entry.getFamily());
        System.out.print("$> ");
        var family = this.scanner.nextLine();

        var phones = getPhoneList();

        this.phoneBookService.editPersonal(entry.getId(), name, family, phones);
    }

    private void editBusinessContactEntry(BusinessEntry entry) {
        System.out.printf("Enter name: (%s)%n", entry.getName());
        System.out.print("$> ");
        var name = this.scanner.nextLine();

        System.out.printf("Enter website: (%s)%n", entry.getWebsite());
        System.out.print("$> ");
        var website = this.scanner.nextLine();

        var phones = getPhoneList();

        this.phoneBookService.editBusiness(entry.getId(), name, website, phones);
    }

    private void removeContactEntry() {
        var entry = getContactEntryById();
        if (entry == null) return;

        System.out.println(entry);
        System.out.println("Are you sure? (y/n)");

        var answer = this.scanner.nextLine();

        if (answer.equals("y")) {
            this.phoneBookService.remove(entry.getId());
            System.out.println("Removed successfully.");
        }
    }

    private Entry getContactEntryById() {
        System.out.println("Enter entry's id:");
        System.out.print("$> ");
        var id = this.scanner.nextLine();

        try {
            var entry = this.phoneBookService.findById(Integer.parseInt(id));
            if (entry == null) {
                System.out.println("Not found any entry.");
            }
            return entry;
        } catch (NumberFormatException e) {
            System.out.println("Invalid Id.");
        }
        return null;
    }

    private PhoneType getPhoneType() {
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
                    return PhoneType.MOBILE;
                }
                case "h" -> {
                    return PhoneType.HOME;
                }
                case "w" -> {
                    return PhoneType.WORK;
                }
                case "f" -> {
                    return PhoneType.FAX;
                }
                default -> System.out.println("Invalid command, try again.");
            }
        }
    }

    private ArrayList<Phone> getPhoneList() {
        var phoneList = new ArrayList<Phone>();

        while (true) {
            var phoneType = getPhoneType();

            System.out.println("Please phone number:");
            System.out.print("$> ");
            var phoneNumber = this.scanner.nextLine();

            phoneList.add(new Phone(phoneType, phoneNumber));

            System.out.println("Add more? (y/n)");
            System.out.print("$> ");
            var answer = this.scanner.nextLine();

            if (!answer.equals("y")) {
                break;
            }
        }

        return phoneList;
    }
}
