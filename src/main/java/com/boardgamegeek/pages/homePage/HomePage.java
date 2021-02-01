package com.boardgamegeek.pages.homePage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.fragments.UserMenuFragment;
import com.boardgamegeek.pages.loggedHomePage.LoggedHomePage;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private UserMenuFragment userMenuFragment;

    public HomePage(WebDriver driver) {
        super(driver);
        this.userMenuFragment = new UserMenuFragment(driver);
    }

    public HomePage clickSignInButton() {
        userMenuFragment.clickSignInButton();
        return this;
    }

    public HomePage clickJoinInButton() {
        userMenuFragment.clickJoinInButton();
        return this;
    }

    public HomePage signIn(String username, String password) {
        userMenuFragment.signIn(username, password);
        return this;
    }

    public String getUsername(LoggedHomePage loggedHomePage) {
        return loggedHomePage.getUserName();
    }

    public String getErrorText(){
        return userMenuFragment.getErrorText();
    }

    public HomePage abortLogIn() {
        userMenuFragment.abortLogIn();
        return this;
    }

}
