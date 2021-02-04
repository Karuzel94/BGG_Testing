package com.boardgamegeek.pages.contactDetailsPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.utilities.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactDetailsPage extends BasePage {

    public TestHelper testHelper;

    public ContactDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        testHelper = new TestHelper();
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
    WebElement stateOrProvinceInput;

    @FindBy(xpath = "//input[@name='zipcode']")
    WebElement zipCodeInput;

    @FindBy(xpath = "//select[@name='country']")
    WebElement countryDropdown;

    @FindBy(xpath = "//select[@name='country']//option[contains(@value,'')]")
    List<WebElement> countryOptionsList;

    @FindBy(xpath = "//input[@name='website']")
    WebElement websiteOrHomepageInput;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@name='xboxlive_gamertag']")
    WebElement xBoxTagInput;

    @FindBy(xpath = "//input[@name='battlenet_account']")
    WebElement battleNetAccountInput;

    @FindBy(xpath = "//input[@name='steam_account']")
    WebElement steamAccountInput;

    @FindBy(xpath = "//input[@name='wii_friendcode']")
    WebElement wiiFriendCodeInput;

    @FindBy(xpath = "//input[@name='psn_id']")
    WebElement psnIdInput;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//input[@name='B1']")
    WebElement submitButton;

    public String countryName() {
        return countryOptionsList.get(testHelper.getRandomNumber(2, countryOptionsList.size())).getText();
    }

    public ContactDetailsPage insertAllDataToContactDetailsForm(String firstName, String lastName, String address, String city,
                                                                String newState, String zipCode, String countryName, String website, String phoneNumber,
                                                                String xboxTag, String battleNetAccount, String steamAccount,
                                                                String wiiFriendCode, String psnId) {
        insertValue(firstNameInput, firstName);
        insertValue(lastNameInput, lastName);
        insertValue(addressInput, address);
        insertValue(cityInput, city);
        insertValue(stateOrProvinceInput, newState);
        insertValue(zipCodeInput, zipCode);
        selectFromDropDownByValue(countryDropdown, countryName);
        insertValue(websiteOrHomepageInput, website);
        insertValue(phoneNumberInput, phoneNumber);
        insertValue(xBoxTagInput, xboxTag);
        insertValue(battleNetAccountInput, battleNetAccount);
        insertValue(steamAccountInput, steamAccount);
        insertValue(wiiFriendCodeInput, wiiFriendCode);
        insertValue(psnIdInput, psnId);
        return this;
    }

    public String getCountryName() {
        return getDropdownSelectedValue(countryDropdown);
    }

    public ContactDetailsPage confirmNewContactData(String password) {
        insertValue(passwordInput, password);
        click(submitButton);
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

    public String getStateOrProvince() {
        return stateOrProvinceInput.getAttribute("value");
    }

    public String getZipCode() {
        return zipCodeInput.getAttribute("value");
    }

    public String getWebsiteOrHomepage() {
        return websiteOrHomepageInput.getAttribute("value");
    }

    public String getPhoneNumber() {
        return phoneNumberInput.getAttribute("value");
    }

    public String getXBoxTag() {
        return xBoxTagInput.getAttribute("value");
    }

    public String getBattleNetAccount() {
        return battleNetAccountInput.getAttribute("value");
    }

    public String getSteamAccount() {
        return steamAccountInput.getAttribute("value");
    }

    public String getWiiFriendCode() {
        return wiiFriendCodeInput.getAttribute("value");
    }

    public String getPsnId() {
        return psnIdInput.getAttribute("value");
    }

}
