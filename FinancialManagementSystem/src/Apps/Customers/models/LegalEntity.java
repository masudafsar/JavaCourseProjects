package Apps.Customers.models;

public class LegalEntity extends Entity<LegalInfo> {
    public LegalEntity(LegalInfo info) {
        super(info);
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
