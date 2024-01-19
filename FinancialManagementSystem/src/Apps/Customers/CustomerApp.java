package Apps.Customers;

import Apps.Customers.services.EntityService;
import utils.ProConsole;

public class CustomerApp implements AutoCloseable, Runnable {
    private final ProConsole console;
    private final EntityService entityService;

    public CustomerApp() {
        console = new ProConsole();
        entityService = new EntityService();
    }

    @Override
    public void run() {

    }

    @Override
    public void close() {
        console.close();
    }
}
