package com.boardgamegeek.pages.accountPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.accountPage.fragments.AccountManagerFragment;
import org.openqa.selenium.WebDriver;

public class AccountPage extends BasePage {

    private AccountManagerFragment accountManagerFragment;

    public AccountPage(WebDriver driver) {
        super(driver);
        this.accountManagerFragment = new AccountManagerFragment(driver);
    }

    public AccountPage goToContactDetailsChangeForm() {
        accountManagerFragment.goToContactDetailsPage();
        return this;
    }


}




