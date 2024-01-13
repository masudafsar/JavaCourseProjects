package application;

import model.*;
import service.PhoneBookService;
import utils.ConsoleUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBookApplication implements AutoCloseable {
    private final ConsoleUtils consoleUtils;
    private final PhoneBookService phoneBookService;

    public PhoneBookApplication() {
        this.consoleUtils = new ConsoleUtils();
        this.phoneBookService = new PhoneBookService();

        this.consoleUtils.printTitle("Welcome to Phone Book application.");
    }

    @Override
    public void close() {
        this.consoleUtils.printTitle("Have a nice day...");

        this.consoleUtils.close();
    }

    public void run() {
        var isRun = true;

        do {
            var command = this.consoleUtils.getValidCommand("Please enter a command to continue:", new HashMap<>() {{
                put("a", "Add new contact");
                put("l", "List of all contacts");
                put("s", "Search in contacts");
                put("e", "Edit contact by id");
                put("r", "Remove contact by id");
                put("q", "Quit");
            }});

            switch (command) {
                case "q" -> isRun = false;
                case "a" -> this.addContact();
                case "l" -> this.showAllContactEntries();
                case "s" -> this.searchInContact();
                case "e" -> this.editContact();
                case "r" -> this.removeContact();
                default -> {
                }
            }
        } while (isRun);
    }

    private void addContact() {
        this.consoleUtils.printSection("Add new contact");
        var type = this.getContactType();
        if (type == null) return; // exit from adding contact

        switch (type) {
            case PERSONAL -> this.addPersonalContact();
            case BUSINESS -> this.addBusinessContact();
        }
    }

    private ContactType getContactType() {
        var command = this.consoleUtils.getValidCommand("Please enter type of contact type:", new HashMap<>() {{
            put("p", "Personal type");
            put("b", "Business type");
            put("x", "Back to application menu");
        }});

        ContactType contactType = null;
        switch (command) {
            case "p" -> contactType = ContactType.PERSONAL;
            case "b" -> contactType = ContactType.BUSINESS;
            case "x" -> {
            }
        }

        return contactType;
    }

    private void addPersonalContact() {
        var name = this.consoleUtils.input("Enter name:");
        var family = this.consoleUtils.input("Enter family:");

        var entries = getEntriesList();

        this.phoneBookService.appendPersonal(name, family, entries);
    }

    private void addBusinessContact() {
        var name = this.consoleUtils.input("Enter name:");
        var website = this.consoleUtils.input("Enter website:");

        var entries = getEntriesList();

        this.phoneBookService.appendBusiness(name, website, entries);
    }

    private void showAllContactEntries() {
        if (this.phoneBookService.getContacts().isEmpty()) {
            this.consoleUtils.printError("PhoneBook is empty!");
            return;
        }
        this.consoleUtils.printSection("List of contacts");
        this.phoneBookService.getContacts().values().forEach(contact -> {
            System.out.println(contact);
            this.consoleUtils.horizontalLine();
        });
    }

    private void searchInContact() {
        this.consoleUtils.printSection("Search in contacts");
        var query = this.consoleUtils.input("Enter query:");

        var filteredContacts = this.phoneBookService.filterContacts(query);

        if (filteredContacts.isEmpty()) {
            this.consoleUtils.printWarning("Not found any contact.");
            return;
        }
        this.consoleUtils.printSection("Filtered contacts");
        filteredContacts.values().forEach(contact -> {
            System.out.println(contact);
            this.consoleUtils.horizontalLine();
        });
    }

    private void editContact() {
        var contact = getContactById();
        if (contact == null) return;

        System.out.println(contact);
        var answer = this.consoleUtils.input("Are you sure? (y/n)");

        if (answer.equals("y")) {
            this.consoleUtils.printSection("Edit contact");
            var type = this.getContactType();
            if (type == null) return; // exit from editing contact

            switch (type) {
                case PERSONAL -> this.editPersonalContact((PersonalContact) contact);
                case BUSINESS -> this.editBusinessContact((BusinessContact) contact);
            }

            this.consoleUtils.printSuccess("Updated successfully.");
        }
    }

    private void editPersonalContact(PersonalContact contact) {
        var name = this.consoleUtils.input(String.format("Enter name: (%s)%n", contact.getName()));
        var family = this.consoleUtils.input(String.format("Enter family: (%s)%n", contact.getFamily()));

        var entries = getEntriesList();

        this.phoneBookService.editPersonal(contact.getId(), name, family, entries);
    }

    private void editBusinessContact(BusinessContact contact) {
        var name = this.consoleUtils.input(String.format("Enter name: (%s)%n", contact.getName()));
        var website = this.consoleUtils.input(String.format("Enter website: (%s)%n", contact.getWebsite()));

        var entries = getEntriesList();

        this.phoneBookService.editBusiness(contact.getId(), name, website, entries);
    }

    private void removeContact() {
        var contact = getContactById();
        if (contact == null) return;

        System.out.println(contact);

        var answer = this.consoleUtils.ConfirmYesNo("Are you sure?");

        if (answer) {
            this.phoneBookService.remove(contact.getId());
            this.consoleUtils.greenColorText("Removed successfully.");
        }
    }

    private Contact getContactById() {
        String id = this.consoleUtils.input("Enter contact's id:");

        try {
            var contact = this.phoneBookService.findById(Integer.parseInt(id));
            if (contact == null) {
                this.consoleUtils.printWarning("Not found any contact.");
            }
            return contact;
        } catch (NumberFormatException e) {
            this.consoleUtils.printWarning("Invalid Id.");
        }
        return null;
    }

    private EntryType getEntryType() {
        var command = this.consoleUtils.getValidCommand("Please enter type of phone:", new HashMap<>() {{
            put("m", "Mobile");
            put("h", "Home");
            put("w", "Work");
            put("f", "Fax");
        }});

        EntryType entryType = null;
        switch (command) {
            case "m" -> entryType = EntryType.MOBILE;
            case "h" -> entryType = EntryType.HOME;
            case "w" -> entryType = EntryType.WORK;
            case "f" -> entryType = EntryType.FAX;
            default -> {
            }
        }

        return entryType;
    }

    private ArrayList<Entry> getEntriesList() {
        var entries = new ArrayList<Entry>();

        var addContactEntry = true;
        do {
            var entryType = getEntryType();
            var entryValue = this.consoleUtils.input("Please phone number:");

            entries.add(new Entry(entryType, entryValue));

            addContactEntry = this.consoleUtils.ConfirmYesNo("Add more?");

        } while (addContactEntry);

        return entries;
    }
}
