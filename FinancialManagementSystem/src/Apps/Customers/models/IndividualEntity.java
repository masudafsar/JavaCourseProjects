package Apps.Customers.models;

public class IndividualEntity extends Entity {
    public IndividualEntity() {
        super(new IndividualInfo());
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
