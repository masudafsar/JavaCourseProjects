package models.info;

import interfaces.Printable;
import interfaces.Searchable;

public abstract class CustomerInfo implements Searchable, Printable {
    private String address;

    public CustomerInfo(String address) {
        this.setAddress(address);
    }

    @Override
    public abstract String toString();

    @Override
    public boolean searchBy(String query) {
        return false;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
