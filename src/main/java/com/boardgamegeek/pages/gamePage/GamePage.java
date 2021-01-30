package com.boardgamegeek.pages.gamePage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.fragments.LoggedUserMenuFragment;
import com.boardgamegeek.pages.fragments.MenuFragment;
import com.boardgamegeek.pages.fragments.UserMenuFragment;
import com.boardgamegeek.pages.gamePage.fragments.GamePropertiesFragment;
import org.openqa.selenium.WebDriver;

public class GamePage extends BasePage {

    private GamePropertiesFragment gamePropertiesFragment;
    private MenuFragment menuFragment;
    private UserMenuFragment userMenuFragment;
    private LoggedUserMenuFragment loggedUserMenuFragment;

    public GamePage(WebDriver driver) {
        super(driver);
        this.gamePropertiesFragment = new GamePropertiesFragment(driver);
        this.menuFragment = new MenuFragment(driver);
        this.userMenuFragment = new UserMenuFragment(driver);
        this.loggedUserMenuFragment = new LoggedUserMenuFragment(driver);
    }

    public GamePage addGameToCollection() {
        gamePropertiesFragment.addGameToCollection();
        return this;
    }

    public GamePage goToCollection() {
        loggedUserMenuFragment.goToCollection();
        return this;
    }

    public String getGameTitle() {
        return gamePropertiesFragment.getGameTitle();
    }

    public GamePage returnHomePage() {
        menuFragment.returnHomePage();
        return this;
    }
}




