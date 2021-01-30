package com.boardgamegeek.pages.contactDetailsPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.contactDetailsPage.fragments.ContactInformationFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPage extends BasePage {

    private ContactInformationFragment contactInformationFragment;

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
        this.contactInformationFragment = new ContactInformationFragment(driver);
    }

    public ContactDetailsPage insertDataToContactDetailsFormAndConfirm(String firstame, String lastname, String address, String city,
                                                                       String newState, String zipCode, String website, String phoneNumber,
                                                                       String xboxTag, String battlenetAccount, String steamAccount,
                                                                       String wiiFriendCode, String psnId, String password) {
        contactInformationFragment.insertDataToContactDetailsFormAndConfirm( firstame, lastname, address, city,
                                                                             newState, zipCode, website, phoneNumber,
                                                                             xboxTag, battlenetAccount, steamAccount,
                                                                             wiiFriendCode, psnId, password);
        return this;
    }

    public String getFirstName(){
        return contactInformationFragment.getFirstName();
    }

    public String getLastName(){
        return contactInformationFragment.getLastName();
    }

    public String getAddress(){
        return contactInformationFragment.getAddress();
    }

    public String getCity(){
        return contactInformationFragment.getCity();
    }

    public String getNewState(){
        return contactInformationFragment.getNewState();
    }

    public String getZipCode(){
        return contactInformationFragment.getZipCode();
    }

    public String getWebsiteAddress(){
        return contactInformationFragment.getWebsiteAddress();
    }

    public String getPhoneNumber(){
        return contactInformationFragment.getPhoneNumber();
    }

    public String getXboxTag(){
        return contactInformationFragment.getXboxTag();
    }

    public String getBattlenetAccount(){
        return contactInformationFragment.getBattlenetAccount();
    }

    public String getSteamAccount(){
        return contactInformationFragment.getSteamAccount();
    }

    public String getWiiFriendCode(){
        return contactInformationFragment.getWiiFriendCode();
    }

    public String getPsnId(){
        return contactInformationFragment.getPsnId();
    }

}
