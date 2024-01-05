package utils;

import java.util.Map;
import java.util.Scanner;

public class ConsoleUtils implements AutoCloseable {
    private static final int WIDTH = 64;
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";

    private final Scanner scanner;

    public ConsoleUtils() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void close() {
        scanner.close();
    }

    public String redColorText(String text) {
        return RED + text + RESET;
    }

    public String greenColorText(String text) {
        return GREEN + text + RESET;
    }

    public String yellowColorText(String text) {
        return YELLOW + text + RESET;
    }

    public String blueColorText(String text) {
        return BLUE + text + RESET;
    }

    public void horizontalLine() {
        System.out.println(blueColorText("-".repeat(WIDTH)));
    }

    public void printTitle(String title) {
        var padding = (WIDTH - title.length() - 2) / 2.0;

        System.out.println();
        horizontalLine();
        System.out.printf(
                blueColorText("%s %s %s\n"),
                " ".repeat((int) Math.ceil(padding)),
                title,
                " ".repeat((int) Math.floor(padding))
        );
        horizontalLine();
        System.out.println();
    }

    public void printSection(String title) {
        var padding = (WIDTH - title.length() - 2) / 2.0;

        System.out.printf(
                blueColorText("\n%s %s %s\n"),
                "-".repeat((int) Math.ceil(padding)),
                title,
                "-".repeat((int) Math.floor(padding))
        );
    }

    public void printSuccess(String message) {
        System.out.println(greenColorText(message));
    }

    public void printError(String message) {
        System.out.println(redColorText(message));
    }

    public void printWarning(String message) {
        System.out.println(yellowColorText(message));
    }

    public String input(String prompt) {
        System.out.println(yellowColorText(prompt));
        System.out.print("$> ");
        return this.scanner.nextLine();
    }

    public boolean ConfirmYesNo(String prompt) {
        return this.confirm(prompt, "y", "n");
    }

    public boolean confirm(String prompt, String yesOption, String noOption) {
        var answer = this.input(String.format("%s (%s/%s)", prompt, yesOption, noOption));
        return answer.equals(yesOption);
    }

    public void printCommandList(Map<String, String> commands) {
        commands.forEach((key, value) -> System.out.printf("  - %s \t\t %s%n", greenColorText(key), value));
    }

    public String getCommand(String prompt, Map<String, String> commands) {
        System.out.println(yellowColorText(prompt));
        System.out.println("valid commands:");
        printCommandList(commands);
        System.out.print("$> ");
        return this.scanner.nextLine();
    }

    public String getValidCommand(String prompt, Map<String, String> commands) {
        do {
            var command = this.getCommand(prompt, commands);

            if (commands.containsKey(command)) return command;

            this.printError("Invalid command, try again.");
        } while (true);
    }
}
