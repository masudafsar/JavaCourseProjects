package Apps.Customers.models;

import utils.WordTransformer;

public class LegalInfo extends Info {
    private String title;
    private String registerId;

    @Override
    public String toString() {
        return null;
    }

    @Override
    public boolean searchBy(String query) {
        return false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = WordTransformer.toTitleCase(title);
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }
}
