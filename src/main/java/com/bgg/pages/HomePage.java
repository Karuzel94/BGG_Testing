package com.bgg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage{
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='menu-logo-symbol']")
    WebElement logoSymbol;

    @FindBy(xpath = "//div[@class='c-nav-primary-user']/gg-menu-nav-nouser/ul/li[1]/a")
    WebElement logInBtn;

    @FindBy(xpath = "//div[@class='c-nav-primary-user']/gg-menu-nav-nouser/ul/li[2]/a")
    WebElement registerBtn;

    @FindBy(xpath = "//input[@name='searchTerm']")
    WebElement searchBar;

    @FindBy(xpath = "//input[@id='inputUsername']")
    WebElement userName;

    @FindBy(xpath = "//input[@id='inputPassword']")
    WebElement password;

    @FindBy(xpath = "//div[@class='modal-footer']/button[1]")
    WebElement signInBtn;

    @FindBy(xpath = "//div[@class='modal-footer']/button[2]")
    WebElement signInCancelBtn;

     public void clickJoinIn() {
         checkingVisibilityAndClicking(registerBtn);
     }

     public void clickSignIn() {
         checkingVisibilityAndClicking(logInBtn);
     }

     public void enterUserName(String string) {
         userName.sendKeys(string);
     }

     public void enterPassword(String string) {
         password.sendKeys(string);
     }

     public void confirmSignIn() {
         checkingVisibilityAndClicking(signInBtn);

     }



}
