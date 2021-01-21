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

    @FindBy(xpath = "//div[@class='c-nav-primary-user']/gg-menu-nav-nouser/ul/li[1]/a")
    WebElement logInButton;

    @FindBy(xpath = "//div[@class='c-nav-primary-user']/gg-menu-nav-nouser/ul/li[2]/a")
    WebElement registerButton;

    @FindBy(xpath = "//input[@id='inputUsername']")
    WebElement userNameInput;

    @FindBy(xpath = "//input[@id='inputPassword']")
    WebElement passwordInput;

    @FindBy(xpath = "//div[@class='modal-footer']/button[1]")
    WebElement signInButton;


    public void clickJoinIn() {
        click(registerButton);
    }

    public void clickSignIn() {
        click(logInButton);
    }


    public void signIn(String username, String password) {
        if (userNameInput.isDisplayed()) {
            userNameInput.sendKeys(username);
        }
        if (passwordInput.isDisplayed()) {
            passwordInput.sendKeys(password);
        }
    }

    public void confirmSignIn() {
        click(signInButton);
    }


}
