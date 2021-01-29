package com.boardgamegeek.pages.accountPage.fragments;

import com.boardgamegeek.pages.accountPage.AccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountManagerFragment extends AccountPage {

    public AccountManagerFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@class='forum_table']/tbody/tr[4]/td/div[2]/a")
    WebElement contactDetailsLink;

    public AccountManagerFragment goToDetailsChange() {
        click(contactDetailsLink);
        return this;
    }

}
