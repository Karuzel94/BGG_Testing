package com.boardgamegeek.pages.fragments;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.loggedHomePage.LoggedHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuFragment extends BasePage {

    public MenuFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='text-white ng-scope']")
    WebElement logoButton;

    @FindBy(xpath = "//div[@class='c-nav-primary d-none d-lg-block']/ul[1]/li[1]/button")
    WebElement browseButton;

    @FindBy(xpath = "//div[@class='dropdown-menu-lg container-fluid dropdown-menu show']/div[1]/div[1]/div[1]/span[1]/a")
    WebElement allBoardgamesButton;

    public MenuFragment goToAllBoardgames() {
        click(browseButton);
        click(allBoardgamesButton);
        return this;
    }

    public void returnHomePage() {
        click(logoButton);
    }
}
