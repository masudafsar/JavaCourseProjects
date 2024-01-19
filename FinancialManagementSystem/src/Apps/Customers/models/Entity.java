package Apps.Customers.models;

import interfaces.Printable;
import interfaces.Searchable;
import utils.IdGenerator;

public abstract class Entity<T_INFO extends Info> implements Printable, Searchable {
    private final int id;
    protected T_INFO info;

    public Entity(T_INFO info) {
        this.info = info;
        this.id = IdGenerator.next("Entity");
    }

    @Override
    public abstract String toString();

    @Override
    public abstract boolean searchBy(String query);

    public int getId() {
        return id;
    }

    public T_INFO getInfo() {
        return this.info;
    }

    public void setInfo(T_INFO info) {
        this.info = info;
    }
}
