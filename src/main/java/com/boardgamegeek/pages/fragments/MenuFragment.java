package com.boardgamegeek.pages.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuFragment extends BasePage {

    public MenuFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='global-header-logo ng-scope']/a")
    WebElement logoButton;

    @FindBy(xpath = "//div[@class='c-nav-primary d-none d-lg-block']/ul/li[1]/button")
    WebElement browseButton;

    @FindBy(xpath = "//a[@href='/browse/boardgame']")
    WebElement allBoardgamesButton;

    public MenuFragment goToAllBoardgames() {
        click(browseButton);
        click(allBoardgamesButton);
        return this;
    }

    public void returnHomePage() {
        visibilityCheck(logoButton);
        click(logoButton);
    }
}
