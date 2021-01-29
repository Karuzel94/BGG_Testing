package com.boardgamegeek.pages.loggedHomePage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.fragments.LoggedUserMenuFragment;
import com.boardgamegeek.pages.fragments.MenuFragment;
import com.boardgamegeek.pages.fragments.UserMenuFragment;
import com.boardgamegeek.pages.homePage.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoggedHomePage extends BasePage {

    private MenuFragment menuFragment;
    private LoggedUserMenuFragment loggedUserMenuFragment;

    public LoggedHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.menuFragment = new MenuFragment(driver);
        this.loggedUserMenuFragment = new LoggedUserMenuFragment(driver);
    }

    public LoggedHomePage goToAllBoardgames(){
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

    public LoggedHomePage returnHomePage(){
        menuFragment.returnHomePage();
        return this;
    }


}



