package com.boardgamegeek.pages.gamePage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditFragment extends BasePage {

    public EditFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement saveCollectionButton;

    @FindBy(xpath = "//div[@class='pull-right ng-scope dropdown']//span[@class='glyphicon glyphicon-option-vertical']")
    WebElement moreOptionsButton;

    @FindBy(xpath = "//button[@ng-click='editctrl.deleteItem(editctrl.editdata.item)']")
    WebElement deleteFromCollectionButton;

    @FindBy(xpath = "//button[@ng-click='ok()']")
    WebElement deleteConfirmationButton;

    public EditFragment saveInCollection() {
        visibilityCheck(saveCollectionButton);
        click(saveCollectionButton);
        return this;
    }

    public EditFragment deleteGameFromCollection() {
        click(moreOptionsButton);
        click(deleteFromCollectionButton);
        click(deleteConfirmationButton);
        return this;
    }

}
