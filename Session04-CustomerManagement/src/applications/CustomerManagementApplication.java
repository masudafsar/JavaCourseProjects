package applications;

import utils.ConsoleUtils;

public class CustomerManagementApplication implements AutoCloseable, Runnable {
    private final ConsoleUtils consoleUtils;

    public CustomerManagementApplication() {
        this.consoleUtils = new ConsoleUtils();
    }

    @Override
    public void close() {
        this.consoleUtils.close();
    }

    @Override
    public void run() {
        this.consoleUtils.printTitle("Welcome to Customer Service");
    }
}
