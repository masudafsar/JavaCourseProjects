package models.info;

import utils.WordUtils;

public class IndividualCustomerInfo extends CustomerInfo {
    private String firstName;
    private String lastName;
    private String nationalId;
    private String birthDate;
    private Gender gender;

    public IndividualCustomerInfo(String firstName, String lastName, String nationalId, String birthDate, Gender gender, String address) {
        super(address);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setNationalId(nationalId);
        this.setBirthDate(birthDate);
        this.setGender(gender);
    }

    @Override
    public String toString() {
        return null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = WordUtils.convertToTitleCase(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = WordUtils.convertToTitleCase(lastName);
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
