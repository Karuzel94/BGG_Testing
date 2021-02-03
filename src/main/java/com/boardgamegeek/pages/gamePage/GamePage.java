package com.boardgamegeek.pages.gamePage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.gamePage.fragments.EditFragment;
import com.boardgamegeek.pages.gamePage.fragments.GamePropertiesFragment;
import org.openqa.selenium.WebDriver;

public class GamePage extends BasePage {

    private GamePropertiesFragment gamePropertiesFragment;
    private EditFragment editFragment;

    public GamePage(WebDriver driver) {
        super(driver);
        this.gamePropertiesFragment = new GamePropertiesFragment(driver);
        this.editFragment = new EditFragment(driver);
    }

    public GamePage addGameToCollection() {
        gamePropertiesFragment.clickAddGameToCollection();
        editFragment.saveInCollection();
        return this;
    }

    public String getGameTitle() {
        return gamePropertiesFragment.getGameTitle();
    }

    public String getInformationIsGameAdded() {
        return gamePropertiesFragment.getInfoIsGameAddedToCollection();
    }

    public GamePage deleteGameFromCollection() {
        gamePropertiesFragment.openEditForm();
        editFragment.deleteGameFromCollection();
        return this;
    }

}




