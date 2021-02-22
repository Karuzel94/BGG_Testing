package com.boardgamegeek.pages.gamePage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.gamePage.fragments.EditGamePropertiesFragment;
import com.boardgamegeek.pages.gamePage.fragments.GamePropertiesFragment;
import org.openqa.selenium.WebDriver;

public class GamePage extends BasePage {

    private GamePropertiesFragment gamePropertiesFragment;
    private EditGamePropertiesFragment editGamePropertiesFragment;

    public GamePage(WebDriver driver) {
        super(driver);
        this.gamePropertiesFragment = new GamePropertiesFragment(driver);
        this.editGamePropertiesFragment = new EditGamePropertiesFragment(driver);
    }

    public GamePage addGameToCollection() {
        gamePropertiesFragment.clickAddGameToCollection();
        editGamePropertiesFragment.saveInCollection();
        return this;
    }

    public GamePage clickInCollectionButton() {
        synchronization2();
        gamePropertiesFragment.clickInCollectionButton();
        return this;
    }

    public String getGameTitle() {
        return gamePropertiesFragment.getGameTitle();
    }

    public String getInformationIsGameAdded() {
        return gamePropertiesFragment.getInfoIsGameAddedToCollection();
    }

    public String getWishListSelectedOption() {
        return gamePropertiesFragment.getWishlistSelectedOption();
    }

    public GamePage deleteGameFromCollection() {
        gamePropertiesFragment.openEditForm();
        editGamePropertiesFragment.deleteGameFromCollection();
        return this;
    }

    public String getLanguageDependenceInformation() {
        return gamePropertiesFragment.getLanguageDependenceInformation();
    }

    public String getGameId() {
        return gamePropertiesFragment.getGameId();
    }

    public GamePage giveMyRating(int rating) {
        if(gamePropertiesFragment.checkIfRatingHasBeenGiven()){
            editGamePropertiesFragment.deleteMyRating();
            gamePropertiesFragment.addMyRatingForGame(rating);
            editGamePropertiesFragment.saveInCollection();
        } else {
            gamePropertiesFragment.addMyRatingForGame(rating);
            editGamePropertiesFragment.saveInCollection();
        }
        return this;
    }

    public int getSettedRating() {
        return gamePropertiesFragment.getSettedRating();
    }

    public int countStarsNumber() {
        return gamePropertiesFragment.countStarsNumber();
    }

}




