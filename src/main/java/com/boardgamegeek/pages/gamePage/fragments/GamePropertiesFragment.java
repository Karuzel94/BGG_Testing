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

    @FindBy(xpath = "//span[@ng-show='overstar > 0 || collratingctrl.collection.ratingitem.rating > 0 ']")
    WebElement settedMyRating;

    @FindBy(xpath = "//span[@ng-show='collratingctrl.collection.ratingitem.rating']")
    WebElement editMyRating;

    @FindBy(xpath = "//span[@ng-repeat-start='r in range track by $index']")
    List<WebElement> ratingStarsIcons;

    @FindBy(xpath = "//i[@ng-mouseenter='enter($index + 1)']")
    List<WebElement> ratingStarsButtons;

    @FindBy(xpath = "//button[@class='cg-notify-close']")
    WebElement itemUpdatedInformationCloseButton;

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
        if (settedMyRating.isDisplayed()) {
            click(editMyRating);
            return true;
        } else {
            return false;
        }
    }

    public GamePropertiesFragment addMyRatingForGame(int rating) {
        if (itemUpdatedInformationCloseButton.isDisplayed()) {
            click(itemUpdatedInformationCloseButton);
        }
        click(ratingStarsButtons.get(rating));
        return this;
    }

    public int getSettedRating() {
        return Integer.parseInt(settedMyRating.getText().replaceAll("\\D+", ""));
    }

    public int countStarsNumber() {
        int counter = 0;
        for (int i = 1; i <= ratingStarsIcons.size(); i++) {
            if (ratingStarsIcons.get(counter).getText().equals("(*)")) {
                counter = i;
                continue;
            } else {
                break;
            }
        }
        return counter;
    }
}
