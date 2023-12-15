package info.afsar.java;

import java.util.ArrayList;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        var entries = new ArrayList<PhoneBookEntry>();
        var scanner = new Scanner(System.in);
        System.out.println("Welcome to Phone Book application.");

        mainLoop:
        while (true) {
            System.out.println("Please enter a command to continue:");
            System.out.println("valid commands:");
            System.out.println(" - a        Add new entry");
            System.out.println(" - l        List of all entries");
            System.out.println(" - q        Quit");

            String command = scanner.nextLine();

            switch (command) {
                case "q":
                    break mainLoop;
                case "a":
                    System.out.println("----- Add new entry -----");
                    var entry = new PhoneBookEntry();
                    System.out.println("Enter title of contact:");
                    entry.setTitle(scanner.nextLine());
                    System.out.println("Enter phone of contact:");
                    entry.setPhone(scanner.nextLine());
                    System.out.println("Added: " + entry.getTitle() + "\t\t\t(" + entry.getPhone() + ")");

                    entries.add(entry);
                    break;
                case "l":
                    System.out.println("----- List of entries -----");
                    for (PhoneBookEntry entry2: entries) {
                        System.out.println(entry2.getTitle() + "\t\t\t(" + entry2.getPhone() + ")");
                        System.out.println("--------------------");
                    }
                    break;
                default:
                    System.out.println("Invalid command, try again.");
                    break;
            }
        }

        System.out.println("Have a nice day...");
    }
}
