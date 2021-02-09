package com.boardgamegeek.pages.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMenuFragment extends BasePage {

    public UserMenuFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='mygeek-dropdown-username text-truncate']")
    WebElement userMenu;

    @FindBy(xpath = "//a[@href='/collection/user/qwerty1234z']")
    WebElement collectionButton;

    @FindBy(xpath = "//fa-icon[@class='ng-fa-icon fs-sm align-middle']")
    WebElement logOutButton;

    @FindBy(xpath = "//a[@href='/geekaccount/edit']")
    WebElement accountButton;

    public String getUserName() {
        visibilityCheck(userMenu);
        return userMenu.getText();
    }

    public UserMenuFragment goToCollection() {
        click(userMenu);
        click(collectionButton);
        synchronization2();
        return this;
    }

    public UserMenuFragment logout() {
        click(userMenu);
        click(logOutButton);
        return this;
    }

    public UserMenuFragment goToAccountPage() {
        click(userMenu);
        click(accountButton);
        return this;
    }

}
