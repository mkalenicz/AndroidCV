package com.kalenicz.maciej.supercv;

/**
 * Created by maciej on 22.09.2017.
 */

public class ExperienceItems {
    private String companyNameExperience;
    private String companyDescriptionExperience;
    private String companyDatesExperience;
    private int logoIdExperience;

    public ExperienceItems(String companyNameExperience, String companyDescriptionExperience, String companyDatesExperience, int logoIdExperience) {
        this.companyNameExperience = companyNameExperience;
        this.companyDescriptionExperience = companyDescriptionExperience;
        this.companyDatesExperience = companyDatesExperience;
        this.logoIdExperience = logoIdExperience;
    }

    public String getCompanyNameExperience() {
        return companyNameExperience;
    }

    public String getCompanyDescriptionExperience() {
        return companyDescriptionExperience;
    }

    public String getCompanyDatesExperience() {
        return companyDatesExperience;
    }

    public int getLogoIdExperience() {
        return logoIdExperience;
    }
}
