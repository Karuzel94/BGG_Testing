package com.boardgamegeek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedHomePage extends BasePage {
    public LoggedHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='mygeek-dropdown-username text-truncate']")
    WebElement userMenu;

    @FindBy(xpath = "//div[@class='container-fluid dropdown-menu show']/div/div[2]/a[1]")
    WebElement accountPropertiesButton;

    @FindBy(xpath = "//table[@class='forum_table']/tbody/tr[4]/td/div[2]/a")
    WebElement contactDetailsLink;

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
    WebElement  countrySelect;

    @FindBy(xpath = "//option[@value='Poland']")
    WebElement selectPolandAsCountry;

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

    @FindBy(xpath = "//fa-icon[@class='ng-fa-icon fs-sm align-middle']")
    WebElement logOutButton;

    @FindBy(xpath = "//a[@class='text-white ng-scope']")
    WebElement logoButton;

    public String getLoggedUserLogin() {
        visibilityCheck(userMenu);
        return userMenu.getText();
    }

    public void goToDetailsChange(){
        click(userMenu);
        click(accountPropertiesButton);
        click(contactDetailsLink);
    }

    public LoggedHomePage insertDataToForm(String firstame, String lastname, String address, String city,
                                           String newState, String zipCode, String website, String phoneNumber,
                                           String xboxTag, String battlenetAccount, String steamAccount,
                                           String wiiFriendCode, String psnId, String password){

        insertValue(firstNameInput ,firstame);
        insertValue(lastNameInput,lastname );
        insertValue(addressInput ,address);
        insertValue(cityInput, city);
        insertValue(newStateInput ,newState);
        insertValue(zipCodeInput, zipCode);
        click(countrySelect);
        click(selectPolandAsCountry);
        insertValue(websiteAddressInput,website );
        insertValue(phoneNumberInput ,phoneNumber);
        insertValue(xboxTagInput, xboxTag);
        insertValue(battlenetAccountInput ,battlenetAccount);
        insertValue(steamAccountInput, steamAccount);
        insertValue(wiiInput ,wiiFriendCode);
        insertValue(psnIdInput, psnId);
        insertValue(passwordInput ,password);
        click(sumbitButton);
        return this;
    }
    public LoggedHomePage returnHomePage() {
        click(logoButton);
        return this;
    }

    public LoggedHomePage logout() {
        click(userMenu);
        click(logOutButton);
        return this;
    }

    public String getCity() {
        return cityInput.getAttribute("value");
    }
}



