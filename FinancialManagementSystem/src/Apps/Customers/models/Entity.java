package Apps.Customers.models;

import interfaces.Printable;
import interfaces.Searchable;

public abstract class Entity implements Printable, Searchable {
    private Info info;

    public Entity(Info info) {
        this.info = info;
    }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean searchBy(String query);

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
