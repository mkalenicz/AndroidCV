package com.kalenicz.maciej.supercv;

/**
 * Created by maciej on 22.09.2017.
 */

public class EducationItems {
    private String companyName;
    private String companyDescription;
    private String companyDetails;
    private String companyDates;
    private int logoId;

    public EducationItems(String companyName, String companyDescription, String companyDetails, String companyDates, int logoId) {
        this.companyName = companyName;
        this.companyDescription = companyDescription;
        this.companyDetails = companyDetails;
        this.companyDates = companyDates;
        this.logoId = logoId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(String companyDetails) {
        this.companyDetails = companyDetails;
    }

    public String getCompanyDates() {
        return companyDates;
    }

    public void setCompanyDates(String companyDates) {
        this.companyDates = companyDates;
    }

    public int getLogoId() {
        return logoId;
    }

    public void setLogoId(int logoId) {
        this.logoId = logoId;
    }
}
