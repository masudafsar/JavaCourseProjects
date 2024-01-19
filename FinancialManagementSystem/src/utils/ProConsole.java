package utils;

import java.util.Map;
import java.util.Scanner;

public class ProConsole implements AutoCloseable {
    private static final int CONSOLE_WIDTH = 80;
    private static final String RESET_COLOR = "\u001B[0m";
    private static final String RED_COLOR = "\u001B[31m";
    private static final String GREEN_COLOR = "\u001B[32m";
    private static final String YELLOW_COLOR = "\u001B[33m";
    private static final String BLUE_COLOR = "\u001B[34m";
    private static final String PROMPT_SIGN = "$> ";

    private final Scanner scanner;

    public ProConsole() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void close() {
        scanner.close();
    }

    private String colorText(String text, String color) {
        return color + text + RESET_COLOR;
    }

    public String redColorText(String text) {
        return colorText(text, RED_COLOR);
    }

    public String greenColorText(String text) {
        return colorText(text, GREEN_COLOR);
    }

    public String yellowColorText(String text) {
        return colorText(text, YELLOW_COLOR);
    }

    public String blueColorText(String text) {
        return colorText(text, BLUE_COLOR);
    }

    public void print(String text) {
        System.out.println(text);
    }

    public void skipLine() {
        print(null);
    }

    public void hr() {
        System.out.println(blueColorText("-".repeat(CONSOLE_WIDTH)));
    }

    public void center(String text, Character filler) {
        var padding = (CONSOLE_WIDTH - text.length() - 2) / 2.0;
        print(String.format(blueColorText("%s %s %s"), filler.toString().repeat((int) Math.ceil(padding)), text, filler.toString().repeat((int) Math.floor(padding))));
    }

    public void center(String text) {
        center(text, ' ');
    }

    public void title(String text) {
        var padding = (CONSOLE_WIDTH - text.length() - 2) / 2.0;

        skipLine();
        hr();
        center(text);
        hr();
        skipLine();
    }

    public void section(String text) {
        var padding = (CONSOLE_WIDTH - text.length() - 2) / 2.0;

        skipLine();
        center(text, '-');
    }

    public void success(String text) {
        print(greenColorText(text));
    }

    public void error(String text) {
        print(redColorText(text));
    }

    public void warning(String text) {
        print(yellowColorText(text));
    }

    public String input() {
        print(PROMPT_SIGN);
        return scanner.nextLine();
    }

    public String input(String prompt) {
        warning(prompt);
        return input();
    }

    public boolean confirm(String question, String yesOption, String noOption) {
        var answer = input(String.format("%s (%s/%s)", question, yesOption, noOption));
        return answer.equals(yesOption);
    }

    public boolean confirmYesNo(String question) {
        return confirm(question, "y", "n");
    }

    public void printCommands(Map<String, String> commands) {
        commands.forEach((key, value) -> print(String.format(" - %s \t\t %s", greenColorText(key), value)));
    }

    public String getCommand(String prompt, Map<String, String> commands) {
        print(yellowColorText(prompt));
        print("Valid commands:");
        printCommands(commands);
        return input();
    }

    public String getValidCommand(String prompt, Map<String, String> commands) {
        do {
            var command = getCommand(prompt, commands);

            if (commands.containsKey(command)) return command;

            error("Invalid command, try again.");
        } while (true);
    }
}