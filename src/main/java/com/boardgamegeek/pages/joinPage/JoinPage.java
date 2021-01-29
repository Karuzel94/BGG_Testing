package com.boardgamegeek.pages.joinPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.joinPage.fragments.RegistrationFormFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class JoinPage extends BasePage {

   private RegistrationFormFragment registrationFormFragment;

    public JoinPage(WebDriver driver) {
        super(driver);
        //PageFactory.initElements(driver, this);
        //this.registrationFormFragment = new RegistrationFormFragment(driver);
    }


    public JoinPage registerAccount(String username, String mail, String password) {
        registrationFormFragment.registerAccount(username, mail, password);
        return this;
    }

}
