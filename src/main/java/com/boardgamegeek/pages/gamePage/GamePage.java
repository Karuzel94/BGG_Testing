package com.boardgamegeek.pages.gamePage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.fragments.UserMenuFragment;
import com.boardgamegeek.pages.fragments.MenuFragment;
import com.boardgamegeek.pages.gamePage.fragments.AddGameFragment;
import com.boardgamegeek.pages.gamePage.fragments.GamePropertiesFragment;
import org.openqa.selenium.WebDriver;

public class GamePage extends BasePage {

    private GamePropertiesFragment gamePropertiesFragment;
    private MenuFragment menuFragment;
    private UserMenuFragment userMenuFragment;
    private AddGameFragment addGameFragment;

    public GamePage(WebDriver driver) {
        super(driver);
        this.gamePropertiesFragment = new GamePropertiesFragment(driver);
        this.menuFragment = new MenuFragment(driver);
        this.userMenuFragment = new UserMenuFragment(driver);
        this.addGameFragment = new AddGameFragment(driver);
    }

    public GamePage addGameToCollection() {
        gamePropertiesFragment.clickAddGameToCollection();
        addGameFragment.saveInCollection();
        return this;
    }

    public GamePage goToCollection() {
        userMenuFragment.goToCollection();
        return this;
    }

    public String getGameTitle() {
        return gamePropertiesFragment.getGameTitle();
    }

    public String getInformationIsGameAdded() {
        return gamePropertiesFragment.getInfoIsGameAddedToCollection();
    }

    public GamePage returnHomePage() {
        menuFragment.returnHomePage();
        return this;
    }
}




