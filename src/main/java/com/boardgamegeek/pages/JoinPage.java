package com.boardgamegeek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinPage extends BasePage {


    public JoinPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='join-username']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@id='join-email']")
    WebElement mailInput;

    @FindBy(xpath = "//input[@id='join-password']")
    WebElement passwordInput;

    @FindBy(xpath = "//div[@class='signup']/form/button")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-link text-muted']")
    WebElement skipAdditionalInformation;

    @FindBy(xpath = "//li[@class='c-nav-session dropdown-primary']/a")
    WebElement registerButton;


    public void clickJoinIn() {
        click(registerButton);
    }

    public void registerAccount(String username , String mail , String password) {
        visibilityCheck(usernameInput);
        usernameInput.sendKeys(username);
        visibilityCheck(mailInput);
        mailInput.sendKeys(mail);
        visibilityCheck(passwordInput);
        passwordInput.sendKeys(password);

    }

    public void createAnAccount() {
        click(createAnAccountButton);
    }

    public void skipAdditionalInfo() {
        click(skipAdditionalInformation);
    }

}
