package com.boardgamegeek.pages.joinPage;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JoinPage extends BasePage {

    public JoinPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@formcontrolname='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@id='join-email']")
    WebElement mailInput;

    @FindBy(xpath = "//input[@id='join-password']")
    WebElement passwordInput;

    @FindBy(xpath = "//div[@class='signup']/form/button")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//button[@class='btn btn-lg btn-link text-muted']")
    WebElement skipAdditionalInformation;

    public void accountRegistration(String username, String mail, String password) {
        insertValue(usernameInput, username);
        insertValue(mailInput, mail);
        insertValue(passwordInput, password);
        click(createAnAccountButton);
        click(skipAdditionalInformation);
    }

}
