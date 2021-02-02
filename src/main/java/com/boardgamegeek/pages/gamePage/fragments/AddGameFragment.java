package com.boardgamegeek.pages.gamePage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddGameFragment extends BasePage {

    public AddGameFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement saveCollectingButton;

    public AddGameFragment saveInCollection() {
        visibilityCheck(saveCollectingButton);
        click(saveCollectingButton);
        return this;
    }
}
