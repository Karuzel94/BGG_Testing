package com.boardgamegeek.pages.gamePage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(xpath = "//span[@ng-bind-html='geekitemctrl.geekitem.data.item.polls.languagedependence|to_trusted']")
    WebElement languageDependenceInformation;

    @FindBy(xpath = "//div[@class='game-itemid ng-binding']")
    WebElement gameId;

    @FindBy(xpath = "//span[@class='rating-stars-secondary']//span[@class='ng-binding']")
    WebElement givenMyRating;

    @FindBy(xpath = "//span[@ng-show='collratingctrl.collection.ratingitem.rating']")
    WebElement editMyRating;

    @FindBy(xpath = "//i[@class='glyphicon ng-scope fi-star is-active']")
    List<WebElement> ratingStarsIcons;

    @FindBy(xpath = "//i[@ng-mouseenter='enter($index + 1)']")
    List<WebElement> ratingStarsButtons;

    public String getGameTitle() {
        visibilityCheck(gameTitle);
        return gameTitle.getText();
    }

    public String getGameId() {
        return gameId.getText().replaceAll("\\D+", "");
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

    public String getLanguageDependenceInformation() {
        return languageDependenceInformation.getText();
    }

    public boolean checkIfRatingHasBeenGiven() {
        return editMyRating.isDisplayed();
    }

    public GamePropertiesFragment clickEditMyRating() {
        click(editMyRating);
        return this;
    }

    public GamePropertiesFragment addMyRatingForGame(int rating) {
        click(ratingStarsButtons.get(rating - 1));
        return this;
    }

    public int getMyRating() {
        return Integer.parseInt(givenMyRating.getText().replaceAll("\\D+", ""));
    }

    public int countStarsNumber() {
        return ratingStarsIcons.size();
    }
}
