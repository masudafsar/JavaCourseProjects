package model;

public class Entry {
    private EntryType type;
    private String value;

    public Entry(EntryType type, String value) {
        this.setType(type);
        this.setValue(value);
    }

    @Override
    public String toString() {
        return String.format("%s \t\t %s", this.getValue(), this.getType());
    }

    public EntryType getType() {
        return this.type;
    }

    private void setType(EntryType type) {
        this.type = type;
    }

    public String getValue() {
        return this.value;
    }

    private void setValue(String value) {
        this.value = value;
    }
}
