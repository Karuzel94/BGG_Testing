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

    public String getWishlistSelectedOption() {
        return gamePropertiesFragment.getWishlistSelectedOption();
    }

    public GamePage deleteGameFromCollection() {
        gamePropertiesFragment.openEditForm();
        editGamePropertiesFragment.deleteGameFromCollection();
        return this;
    }

}




