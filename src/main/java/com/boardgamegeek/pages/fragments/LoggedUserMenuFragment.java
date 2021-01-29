package com.boardgamegeek.pages.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedUserMenuFragment extends BasePage {

    public LoggedUserMenuFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='mygeek-dropdown-username text-truncate']")
    WebElement userMenu;

    @FindBy(xpath = "//div[@class='container-fluid dropdown-menu show']/div/div[1]/a[3]")
    WebElement collectionButton;

    @FindBy(xpath = "//fa-icon[@class='ng-fa-icon fs-sm align-middle']")
    WebElement logOutButton;

    @FindBy(xpath = "//div[@class='container-fluid dropdown-menu show']/div/div[2]/a[1]")
    WebElement accountPropertiesButton;


    public String getLoggedUserLogin() {
        visibilityCheck(userMenu);
        return userMenu.getText();
    }
    public LoggedUserMenuFragment goToCollection() {
        click(userMenu);
        click(collectionButton);
        return this;
    }

    public LoggedUserMenuFragment logout() {
        click(userMenu);
        click(logOutButton);
        return this;
    }

    public LoggedUserMenuFragment goToAccountPage() {
        click(userMenu);
        click(accountPropertiesButton);
        return this;
    }

}
