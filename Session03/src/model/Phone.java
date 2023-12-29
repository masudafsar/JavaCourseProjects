package model;

public class Phone {
    private PhoneType type;
    private String value;

    public Phone(PhoneType type, String value) {
        this.setType(type);
        this.setValue(value);
    }

    @Override
    public String toString() {
        return String.format("%s \t\t %s", this.getValue(), this.getType());
    }

    public PhoneType getType() {
        return this.type;
    }

    private void setType(PhoneType type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    private void setValue(String value) {
        this.value = value;
    }
}
