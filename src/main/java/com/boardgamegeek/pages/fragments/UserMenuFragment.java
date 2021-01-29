package com.boardgamegeek.pages.fragments;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.homePage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenuFragment extends BasePage {

    public UserMenuFragment(WebDriver driver) {
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

    public UserMenuFragment clickJoinInButton() {
        click(registerButton);
        return this;
    }

    public UserMenuFragment clickSignInButton() {
        click(logInButton);
        return this;
    }

    public UserMenuFragment signIn(String username, String password) {
        insertValue(userNameInput, username);
        insertValue(passwordInput, password);
        visibilityCheck(invalidDataCommunicate);
        click(signInButton);
        return this;
    }

    public UserMenuFragment abortLogIn() {
        click(cancelSignIn);
        return this;
    }

    public String getErrorText() {
        visibilityCheck(inputAfterError);
        return invalidDataCommunicate.getText();
    }



}
