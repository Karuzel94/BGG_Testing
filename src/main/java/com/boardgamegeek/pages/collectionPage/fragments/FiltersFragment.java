package com.boardgamegeek.pages.collectionPage.fragments;

import com.boardgamegeek.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FiltersFragment extends BasePage {

    public FiltersFragment(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='collectionfilter_body']/input[2][@value='Apply Filters']")
    WebElement applyButton;

    @FindBy(xpath = "//input[@aria-labelledby='heading_geekrating minrating']")
    WebElement minGeekRating;

    @FindBy(xpath = "//input[@aria-labelledby='heading_geekrating maxrating']")
    WebElement maxGeekRating;

    @FindBy(xpath = "//select[@id='wishlistpriority']")
    WebElement wishListPrioritySelect;

    @FindBy(xpath = "//div[@id='collection_status']")
    WebElement loadingInformation;

    @FindBy(xpath = "//select[@id='wishlistpriority']//option[contains(text(),' - ')]")
    List<WebElement> wishListPrioritySelectOptions;

    public FiltersFragment geekRatingFiltering(Double min, Double max) {
        insertDoubleValue(minGeekRating, min);
        insertDoubleValue(maxGeekRating, max);
        return this;
    }

    public String getWishListSelectedOption() {
        return getDropdownSelectedValue(wishListPrioritySelect);
    }

    public FiltersFragment chooseRandomWishListPriorityOption() {
        selectRandomDropdownOption(wishListPrioritySelectOptions, wishListPrioritySelect);
        return this;
    }

    public FiltersFragment acceptFilters() {
        click(applyButton);
        synchronization(loadingInformation);
        return this;
    }
}
