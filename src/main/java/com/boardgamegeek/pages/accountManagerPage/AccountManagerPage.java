package com.boardgamegeek.pages.accountManagerPage;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountManagerPage extends BasePage {

    public AccountManagerPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/geekaccount.php?action=editcontact']")
    WebElement contactDetailsLink;

    public AccountManagerPage goToContactDetailsPage() {
        click(contactDetailsLink);
        return this;
    }
}




