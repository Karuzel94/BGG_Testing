package com.boardgamegeek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedHomePage extends AbstractPage {
    public LoggedHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='mygeek-dropdown-username text-truncate']")
    WebElement userMenu;

    @FindBy(xpath = "//fa-icon[@class='ng-fa-icon fs-sm align-middle']")
    WebElement logOutButton;

    public String getLoggedUserLogin() {
        visibilityCheck(userMenu);
        return userMenu.getText();
    }

    public void logout() {
        click(userMenu);
        click(logOutButton);
    }
}



