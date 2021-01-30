package com.boardgamegeek.pages.homePage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.fragments.LoggedUserMenuFragment;
import com.boardgamegeek.pages.fragments.MenuFragment;
import com.boardgamegeek.pages.fragments.UserMenuFragment;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private MenuFragment menuFragment;
    private UserMenuFragment userMenuFragment;

    public HomePage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
        this.menuFragment = new MenuFragment(driver);
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
        userMenuFragment.signIn(username,password);
        return this;
    }

    public String getErrorText(){
        return userMenuFragment.getErrorText();
    }
    public HomePage goToAllBoardgames(){
        menuFragment.goToAllBoardgames();
        return this;
    }

    public HomePage returnHomePage(){
        menuFragment.returnHomePage();
        return this;
    }

    public HomePage abortLogIn() {
        userMenuFragment.abortLogIn();
        return this;
    }

}
