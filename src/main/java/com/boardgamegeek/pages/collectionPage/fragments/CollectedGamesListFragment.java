package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CollectedGamesListFragment extends BasePage {

    public CollectedGamesListFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /*
    @FindBy(xpath = "//a[contains(@id,'results_objectname')]/a")
    List<WebElement> gamesinCollectionList;
    (By.xpath("//a[contains(text(), 'TESTING')]"))
    */

    public CollectedGamesListFragment clickGameFromList(String name){
        click(driver.findElement(By.xpath("//div[contains(@id,'results_objectname')]/a[text()='" + name + "']")));
        return this;
    }

}
