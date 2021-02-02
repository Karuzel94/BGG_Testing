package com.boardgamegeek.pages.gamePage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GamePropertiesFragment extends BasePage {

    public GamePropertiesFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='hidden-xs']//button[@class='btn btn-sm btn-primary toolbar-action-full']")
    WebElement addToCollectionButton;

    @FindBy(xpath = "//span[@class='hidden-xs']//button[@class='btn btn-sm btn-subtle dropdown-toggle']")
    WebElement inCollectionButton;

    @FindBy(xpath = "//h1/a[@ui-sref='geekitem.overview']")
    WebElement gameTitle;

    public String getGameTitle() {
        visibilityCheck(gameTitle);
        return gameTitle.getText();
    }

    public String getInfoIsGameAddedToCollection() {
        return inCollectionButton.getText();
    }

    public GamePropertiesFragment clickAddGameToCollection() {
        click(addToCollectionButton);
        return this;
    }
}
