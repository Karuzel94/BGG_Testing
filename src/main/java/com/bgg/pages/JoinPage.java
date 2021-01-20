package com.bgg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinPage extends AbstractPage {


    public JoinPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='join-username']")
    WebElement newUserName;

    @FindBy(xpath = "//input[@id='join-email']")
    WebElement newUserMail;

    @FindBy(xpath = "//input[@id='join-password']")
    WebElement newUserPassword;

    @FindBy(xpath = "//div[@class='signup']/form/button")
    WebElement createAnAccountBtn;

}
