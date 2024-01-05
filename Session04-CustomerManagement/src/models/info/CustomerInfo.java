package models.info;

public abstract class CustomerInfo {
    private String address;

    public CustomerInfo(String address) {
        this.setAddress(address);
    }

    @Override
    public abstract String toString();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
