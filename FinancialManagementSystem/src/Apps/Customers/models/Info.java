package Apps.Customers.models;

import utils.WordTransformer;

public abstract class Info {
    private String address;
    private String country;
    private String city;
    private String postalCode;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = WordTransformer.toTitleCase(country);
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = WordTransformer.toTitleCase(city);
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
