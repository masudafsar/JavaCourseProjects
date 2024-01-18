package Apps.Customers.models;

public abstract class Entity {
    private Info info;

    public Entity(Info info) {
        this.info = info;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
