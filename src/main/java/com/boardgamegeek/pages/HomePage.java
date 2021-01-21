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


    public void clickJoinIn() {
        click(registerButton);
    }

    public void clickSignIn() {
        click(logInButton);
    }


    public void signIn(String username, String password) {
        visibilityCheck(userNameInput);
        userNameInput.sendKeys(username);
        visibilityCheck(passwordInput);
        passwordInput.sendKeys(password);

    }

    public void confirmSignIn() {
        click(signInButton);
    }

}
