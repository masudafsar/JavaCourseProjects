import applications.CustomerManagementApplication;

public class ApplicationRunner {
    public static void main(String[] args) {
        try (var application = new CustomerManagementApplication()) {
            application.run();
        }
    }
}
