package com.boardgamegeek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public abstract class BasePage {

    protected WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        int waitTimeSeconds = 10;
        wait = new WebDriverWait(this.driver, waitTimeSeconds);
    }

    public void visibilityCheck(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void checkElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        visibilityCheck(element);
        checkElementClickable(element);
        element.click();
    }

    public void selectFromDropdown(WebElement element, String name) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(name);
    }

    public void selectRandomOptionFromDropdown(List<WebElement> list, WebElement element) {
        Random rand = new Random();
        int randomIndexFromDropdownList = rand.nextInt(list.size());
        String randomString = list.get(randomIndexFromDropdownList).getText();
        Select dropdown = new Select(element);
        dropdown.selectByValue(randomString);
    }

    public String getDropdownSelectedValue(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getAttribute("value");
    }

    public void insertValue(WebElement element, String value) {
        visibilityCheck(element);
        element.sendKeys(value);
    }
}
