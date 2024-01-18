package Apps.Customers.models;

import utils.WordTransformer;

public class IndividualInfo extends Info {
    private String firstName;
    private String lastName;
    private String nationalId;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = WordTransformer.toTitleCase(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = WordTransformer.toTitleCase(lastName);
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }
}
