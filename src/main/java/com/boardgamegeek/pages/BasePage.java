package com.boardgamegeek.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private int waitTimeSeconds = 15;
    protected WebDriver driver;
    protected static WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, waitTimeSeconds);
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
}
