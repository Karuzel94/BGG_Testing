package com.boardgamegeek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

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

    @FindBy(xpath = "//span[@class='help-block']")
    WebElement invalidDataCommunicate;

    @FindBy(xpath = "//input[@class='form-control ng-dirty ng-touched ng-valid']")
    WebElement inputAfterError;

    @FindBy(xpath = "//button[@class='btn btn-outline-secondary']")
    WebElement cancelSignIn;


    public HomePage clickJoinInButton() {
        click(registerButton);
        return this;
    }

    public HomePage clickSignInButton() {
        click(logInButton);
        return this;
    }

    public HomePage signIn(String username, String password) {
        insertValue(userNameInput, username);
        insertValue(passwordInput, password);
        visibilityCheck(invalidDataCommunicate);
        click(signInButton);
        return this;
    }

    public HomePage abortLogIn() {
        click(cancelSignIn);
        return this;
    }

    public String getErrorText() {
        visibilityCheck(inputAfterError);
        return invalidDataCommunicate.getText();
    }

    public String getUsername(LoggedHomePage loggedHomePage) {
        return loggedHomePage.getLoggedUserLogin();
    }

}
