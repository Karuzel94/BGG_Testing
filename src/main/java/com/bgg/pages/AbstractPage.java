package com.bgg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

    private int waitTime = 5;
    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPage (WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, waitTime);
    }

    /*public void checkingVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(WebElement element){
        checkingVisibility(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }*/


}
