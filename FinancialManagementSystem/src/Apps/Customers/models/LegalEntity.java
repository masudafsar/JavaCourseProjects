package Apps.Customers.models;

public class LegalEntity extends Entity {
    public LegalEntity() {
        super(new LegalInfo());
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean searchBy(String query) {
        return false;
    }
}
