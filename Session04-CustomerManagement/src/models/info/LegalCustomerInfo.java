package models.info;

import utils.WordUtils;

public class LegalCustomerInfo extends CustomerInfo {
    private String title;
    private String legalId;
    private String foundDate;
    private String website;

    public LegalCustomerInfo(String title, String legalId, String foundDate, String website, String address) {
        super(address);
        this.title = title;
        this.legalId = legalId;
        this.foundDate = foundDate;
        this.website = website;
    }

    @Override
    public String toString() {
        return null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = WordUtils.convertToTitleCase(title);
    }

    public String getLegalId() {
        return legalId;
    }

    public void setLegalId(String legalId) {
        this.legalId = legalId;
    }

    public String getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(String foundDate) {
        this.foundDate = foundDate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
