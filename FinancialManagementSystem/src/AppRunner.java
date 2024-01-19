import Apps.Customers.CustomerApp;

public class AppRunner {
    public static void main(String[] args) {
        try (var application = new CustomerApp()) {
            application.run();
        }
    }
}
