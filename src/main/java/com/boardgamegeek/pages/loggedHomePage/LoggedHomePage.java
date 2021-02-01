package com.boardgamegeek.pages.loggedHomePage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.fragments.LoggedUserMenuFragment;
import com.boardgamegeek.pages.fragments.MenuFragment;
import org.openqa.selenium.WebDriver;

public class LoggedHomePage extends BasePage {

    private MenuFragment menuFragment;
    private LoggedUserMenuFragment loggedUserMenuFragment;

    public LoggedHomePage(WebDriver driver) {
        super(driver);
        this.loggedUserMenuFragment = new LoggedUserMenuFragment(driver);
        this.menuFragment = new MenuFragment(driver);
    }

    public LoggedHomePage goToAllBoardgames() {
        menuFragment.goToAllBoardgames();
        return this;
    }

    public String getUserName() {
        return loggedUserMenuFragment.getLoggedUserLogin();
    }

    public LoggedHomePage goToAccountPage() {
        loggedUserMenuFragment.goToAccountPage();
        return this;
    }

    public LoggedHomePage returnHomePage() {
        menuFragment.returnHomePage();
        return this;
    }

    public LoggedHomePage logout() {
        loggedUserMenuFragment.logout();
        return this;
    }

}



