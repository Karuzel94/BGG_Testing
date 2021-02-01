package com.boardgamegeek.pages.contactDetailsPage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactInformationFragment extends BasePage {

    public ContactInformationFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='firstname']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='streetaddr1']")
    WebElement addressInput;

    @FindBy(xpath = "//input[@name='city']")
    WebElement cityInput;

    @FindBy(xpath = "//input[@name='newstate']")
    WebElement newStateInput;

    @FindBy(xpath = "//input[@name='zipcode']")
    WebElement zipCodeInput;

    @FindBy(xpath = "//select[@name='country']")
    WebElement countrySelect;

    @FindBy(xpath = "//select[@id='country']/option")
    List<WebElement> countrySelectedFromList;

    @FindBy(xpath = "//input[@name='website']")
    WebElement websiteAddressInput;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@name='xboxlive_gamertag']")
    WebElement xboxTagInput;

    @FindBy(xpath = "//input[@name='battlenet_account']")
    WebElement battlenetAccountInput;

    @FindBy(xpath = "//input[@name='steam_account']")
    WebElement steamAccountInput;

    @FindBy(xpath = "//input[@name='wii_friendcode']")
    WebElement wiiInput;

    @FindBy(xpath = "//input[@name='psn_id']")
    WebElement psnIdInput;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@name='B1']")
    WebElement sumbitButton;


    public ContactInformationFragment getCountry(int number) {
        click(countrySelectedFromList.get(number));
        return this;
    }

    public ContactInformationFragment insertDataToContactDetailsForm(String firstName, String lastName, String address, String city,
                                                                     String newState, String zipCode, int countryId, String website, String phoneNumber,
                                                                     String xboxTag, String battlenetAccount, String steamAccount,
                                                                     String wiiFriendCode, String psnId) {
        insertValue(firstNameInput, firstName);
        insertValue(lastNameInput, lastName);
        insertValue(addressInput, address);
        insertValue(cityInput, city);
        insertValue(newStateInput, newState);
        insertValue(zipCodeInput, zipCode);
        click(countrySelect);
        getCountry(countryId);
        insertValue(websiteAddressInput, website);
        insertValue(phoneNumberInput, phoneNumber);
        insertValue(xboxTagInput, xboxTag);
        insertValue(battlenetAccountInput, battlenetAccount);
        insertValue(steamAccountInput, steamAccount);
        insertValue(wiiInput, wiiFriendCode);
        insertValue(psnIdInput, psnId);
        return this;
    }

    public String getCountryName(int countryId) {
        return countrySelectedFromList.get(countryId).getAttribute("value");
    }

    public ContactInformationFragment confirmNewContactData(String password) {
        insertValue(passwordInput, password);
        click(sumbitButton);
        return this;
    }

    public String getFirstName() {
        return firstNameInput.getAttribute("value");
    }

    public String getLastName() {
        return lastNameInput.getAttribute("value");
    }

    public String getAddress() {
        return addressInput.getAttribute("value");
    }

    public String getCity() {
        return cityInput.getAttribute("value");
    }

    public String getNewState() {
        return newStateInput.getAttribute("value");
    }

    public String getZipCode() {
        return zipCodeInput.getAttribute("value");
    }

    public String getWebsiteAddress() {
        return websiteAddressInput.getAttribute("value");
    }

    public String getPhoneNumber() {
        return phoneNumberInput.getAttribute("value");
    }

    public String getXboxTag() {
        return xboxTagInput.getAttribute("value");
    }

    public String getBattlenetAccount() {
        return battlenetAccountInput.getAttribute("value");
    }

    public String getSteamAccount() {
        return steamAccountInput.getAttribute("value");
    }

    public String getWiiFriendCode() {
        return wiiInput.getAttribute("value");
    }

    public String getPsnId() {
        return psnIdInput.getAttribute("value");
    }


}
