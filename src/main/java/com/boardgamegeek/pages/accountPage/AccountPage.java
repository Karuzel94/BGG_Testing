package com.boardgamegeek.pages.accountPage;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.pages.accountPage.fragments.AccountManagerFragment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    private AccountManagerFragment accountManagerFragment;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        // this.accountManagerFragment = new AccountManagerFragment(driver);
    }

    public AccountPage goToDetailsChange() {
        accountManagerFragment.goToDetailsChange();
        return this;
    }


}




