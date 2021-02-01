package com.boardgamegeek.pages.contactDetailsPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.contactDetailsPage.fragments.ContactInformationFragment;
import org.openqa.selenium.WebDriver;

public class ContactDetailsPage extends BasePage {

    private ContactInformationFragment contactInformationFragment;

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
        this.contactInformationFragment = new ContactInformationFragment(driver);
    }

    public ContactDetailsPage insertDataToContactDetailsFormAndConfirm(String firstName, String lastName, String address, String city,
                                                                       String newState, String zipCode, int countryIndex, String website, String phoneNumber,
                                                                       String xboxTag, String battlenetAccount, String steamAccount,
                                                                       String wiiFriendCode, String psnId) {
        contactInformationFragment.insertDataToContactDetailsForm(firstName, lastName, address, city,
                newState, zipCode, countryIndex, website, phoneNumber,
                xboxTag, battlenetAccount, steamAccount,
                wiiFriendCode, psnId);
        return this;
    }

    public ContactDetailsPage confirmNewContactDetails(String password) {
        contactInformationFragment.confirmNewContactData(password);
        return this;
    }

    public String getCountryName(int countryId) {
        return contactInformationFragment.getCountryName(countryId);
    }

    public String getFirstName() {
        return contactInformationFragment.getFirstName();
    }

    public String getLastName() {
        return contactInformationFragment.getLastName();
    }

    public String getAddress() {
        return contactInformationFragment.getAddress();
    }

    public String getCity() {
        return contactInformationFragment.getCity();
    }

    public String getNewState() {
        return contactInformationFragment.getNewState();
    }

    public String getZipCode() {
        return contactInformationFragment.getZipCode();
    }

    public String getWebsiteAddress() {
        return contactInformationFragment.getWebsiteAddress();
    }

    public String getPhoneNumber() {
        return contactInformationFragment.getPhoneNumber();
    }

    public String getXboxTag() {
        return contactInformationFragment.getXboxTag();
    }

    public String getBattlenetAccount() {
        return contactInformationFragment.getBattlenetAccount();
    }

    public String getSteamAccount() {
        return contactInformationFragment.getSteamAccount();
    }

    public String getWiiFriendCode() {
        return contactInformationFragment.getWiiFriendCode();
    }

    public String getPsnId() {
        return contactInformationFragment.getPsnId();
    }

}
