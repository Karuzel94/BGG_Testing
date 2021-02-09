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

    @FindBy(xpath = "//div[@class='toolbar-action']//button[@class='btn btn-sm btn-primary toolbar-action-full']")
    WebElement addToCollectionButton;

    @FindBy(xpath = "//div[@class='toolbar-action']//button[@id='button-collection']")
    WebElement inCollectionButton;

    @FindBy(xpath = "//h1/a[@ui-sref='geekitem.overview']")
    WebElement gameTitle;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-subtle collection-dropdown-edit ng-isolate-scope']")
    WebElement editGamePropertiesButton;

    @FindBy(xpath = "//select[@ng-model='item.wishlistpriority']")
    WebElement selectedWishlistOption;

    public String getGameTitle() {
        visibilityCheck(gameTitle);
        return gameTitle.getText();
    }

    public String getInfoIsGameAddedToCollection() {
        return inCollectionButton.getText();
    }

    public String getWishlistSelectedOption() {
        return getDropdownSelectedValue(selectedWishlistOption);
    }

    public GamePropertiesFragment clickInCollectionButton() {
        click(inCollectionButton);
        return this;
    }

    public GamePropertiesFragment clickAddGameToCollection() {
        click(addToCollectionButton);
        return this;
    }

    public GamePropertiesFragment openEditForm() {
        click(inCollectionButton);
        click(editGamePropertiesButton);
        return this;
    }
}
