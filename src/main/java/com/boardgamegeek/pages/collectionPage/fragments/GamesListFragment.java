package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import com.boardgamegeek.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GamesListFragment extends BasePage {

    public GamesListFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private int i;
    /*@FindBy(xpath = "//div[contains(@id,'results_objectname')]/a")
    List<WebElement> gamesInCollectionList;*/

    @FindBy(xpath = "//tr[contains(@id,'row_')]")
    List<WebElement> gamesInCollectionList;

    public GamesListFragment clickGameFromList(String name) {
        for(WebElement element : gamesInCollectionList){
            if(element.getText().contains(name)){
                this.i = gamesInCollectionList.indexOf(element);
                break;
            }
        }
        click(gamesInCollectionList.get(i).findElement(By.xpath(".//div[contains(@id,'results_objectname')]/a")));
        return this;
        }
}


