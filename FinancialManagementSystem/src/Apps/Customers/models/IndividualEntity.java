package Apps.Customers.models;

public class IndividualEntity extends Entity<IndividualInfo> {
    public IndividualEntity(IndividualInfo info) {
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
