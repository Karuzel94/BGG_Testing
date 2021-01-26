package com.boardgamegeek.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='c-nav-session c-nav-primary-separated dropdown-primary']/a")
    WebElement logInButton;


    @FindBy(xpath = "//input[@id='inputUsername']")
    WebElement userNameInput;

    @FindBy(xpath = "//input[@id='inputPassword']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement signInButton;

    @FindBy(xpath = "//li[@class='c-nav-session dropdown-primary']/a")
    WebElement registerButton;

    @FindBy(xpath = "/html/body/ngb-modal-window/div/div/gg-login-modal/form/fieldset/div[1]/div[2]/span")
    WebElement invalidDataCommunicate;


    public void clickJoinInButton() {
        click(registerButton);
    }

    public void clickSignInButton() {
        click(logInButton);
    }


    public void signIn(String username, String password) {
        insertValue(userNameInput, username);
        insertValue(passwordInput, password);
        visibilityCheck(invalidDataCommunicate);
        click(signInButton);
    }

    public boolean errorCheck() {
        visibilityCheck(invalidDataCommunicate);
        if(invalidDataCommunicate.getText().equals("Invalid username or password")){
            return true;
        }else {
            return false;
        }
    }


    public void logInComparisonAssertion(String username_one, String username_two) {
        Assert.assertEquals("The username is different to defined.", username_one, username_two);
    }

}
