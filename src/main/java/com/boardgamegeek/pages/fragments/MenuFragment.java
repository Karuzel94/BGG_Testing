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

    @FindBy(xpath = "//img[@class='global-header-logo-symbol']")
    WebElement logoButton;

    @FindBy(xpath = "//button[text()=' Browse ']")
    WebElement browseButton;

    @FindBy(xpath = "//a[text()=' All Boardgames ']")
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
