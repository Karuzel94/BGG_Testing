package com.boardgamegeek.pages;

import com.boardgamegeek.utilities.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    protected WebDriver driver;
    protected static WebDriverWait wait;
    public TestHelper testHelper;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        int waitTimeSeconds = 10;
        wait = new WebDriverWait(this.driver, waitTimeSeconds);
        testHelper = new TestHelper();
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

    public void selectFromDropDownByValue(WebElement element, String name) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(name);
    }

    public String getDropdownSelectedValue(WebElement element) {
        Select select = new Select(element);
        return select.getFirstSelectedOption().getText();
    }

    public void insertValue(WebElement element, String value) {
        visibilityCheck(element);
        element.clear();
        element.sendKeys(value);
    }
}
