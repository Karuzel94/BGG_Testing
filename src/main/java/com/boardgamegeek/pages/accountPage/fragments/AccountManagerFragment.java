package com.boardgamegeek.pages.accountPage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountManagerFragment extends BasePage {

    public AccountManagerFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@class='forum_table']/tbody/tr[4]/td/div[2]/a")
    WebElement contactDetailsLink;

    public AccountManagerFragment goToContactDetailsPage() {
        click(contactDetailsLink);
        return this;
    }

}
