package com.boardgamegeek.pages.joinPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.joinPage.fragments.RegistrationFormFragment;
import org.openqa.selenium.WebDriver;

public class JoinPage extends BasePage {

    public RegistrationFormFragment registrationFormFragment;

    public JoinPage(WebDriver driver) {
        super(driver);
        this.registrationFormFragment = new RegistrationFormFragment(driver);
    }


    public JoinPage registerAccount(String username, String mail, String password) {
        registrationFormFragment.accountRegistration(username, mail, password);
        return this;
    }

}
