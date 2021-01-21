package com.boardgamegeek.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoggedHomePage extends BasePage {
    public LoggedHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@class='menu-logo-symbol']")
    WebElement logoSymbol;


    @FindBy(xpath = "//*[@class='c-nav-primary-user']/gg-menu-nav-user/ul/li[2]/gg-my-geek/div/button/span[2]")
    WebElement userMenu;

    public String loggedUser() {
        return userMenu.getText();
    }


}
