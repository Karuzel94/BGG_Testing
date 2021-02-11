package com.boardgamegeek.pages;

import com.boardgamegeek.utilities.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected static WebDriverWait wait;
    public TestHelper testHelper;
    private Select dropdown;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        int waitTimeSeconds = 10;
        wait = new WebDriverWait(this.driver, waitTimeSeconds);
        testHelper = new TestHelper();
    }

    public void visibilityCheck(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void synchronization(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void synchronization2() {
        wait.until(ExpectedConditions.attributeContains(By.xpath("//div[@class='pace-progress']"), "data-progress-text", "100%"));
    }

    public void checkElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        visibilityCheck(element);
        checkElementClickable(element);
        element.click();
    }

    public void openInNewTab(WebElement element) {
        visibilityCheck(element);
        checkElementClickable(element);
        element.sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
    }

    private void selectInit(WebElement element) {
        this.dropdown = new Select(element);
    }

    public void selectFromDropDownByValue(WebElement element, String name) {
        selectInit(element);
        dropdown.selectByValue(name);
    }

    public void selectRandomDropdownOption(List<WebElement> list, WebElement element) {
        selectInit(element);
        dropdown.selectByIndex(testHelper.getRandomNumber(1, list.size()));
    }

    public String getDropdownSelectedValue(WebElement element) {
        selectInit(element);
        return dropdown.getFirstSelectedOption().getText();
    }

    public void insertStringValue(WebElement element, String value) {
        visibilityCheck(element);
        element.clear();
        element.sendKeys(value);
    }

    public void insertDoubleValue(WebElement element, Double value) {
        visibilityCheck(element);
        element.clear();
        element.sendKeys(String.valueOf(value));
    }

}
