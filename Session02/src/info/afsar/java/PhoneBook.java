package info.afsar.java;

import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Phone Book application.");

        mainLoop:
        do {
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
                    break;
                case "l":
                    break;
                default:
                    break;
            }
        } while (true);

        System.out.println("Have a nice day...");
    }
}
