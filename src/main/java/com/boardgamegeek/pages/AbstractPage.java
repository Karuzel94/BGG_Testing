package com.boardgamegeek.pages;

import com.boardgamegeek.utilities.TestHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    private int waitTimeSeconds = 10;
    protected WebDriver driver;
    protected static WebDriverWait wait;
    public TestHelper testHelper = new TestHelper();


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
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

    public void insertValue(WebElement element, String value) {
        visibilityCheck(element);
        element.sendKeys(value);

    }
}
