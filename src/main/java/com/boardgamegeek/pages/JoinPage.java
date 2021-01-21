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



    public void setNewUserName(String username) {
        usernameInput.sendKeys(username);
    }

    public void setMailInput(String mail) {
        mailInput.sendKeys(mail);
    }

    public void setNewUserPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void createAnAccount() {
        click(createAnAccountButton);
    }

}
