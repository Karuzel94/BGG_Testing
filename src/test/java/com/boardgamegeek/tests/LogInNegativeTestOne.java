package com.boardgamegeek.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LogInNegativeTestOne extends AbstractTest {


    @Test(dataProvider="getLogInData")
    public void LogInTest (String username, String password) {

        System.out.println(username + ", " +password);
        homePage.clickSignInButton();
        homePage.signIn(username, password);

        Assert.assertNotEquals(testHelper.logInData, loggedHomePage.getLoggedUserLogin());

        System.out.println("Logged user: " + loggedHomePage.getLoggedUserLogin());

        loggedHomePage.logout();

    }
    @DataProvider
    public Object[][] getLogInData(){

        Object[][] getData = new Object[3][2];
        //1st set of Data
        getData[0][0] = "hxHWIJDg";
        getData[0][1] = "GkBw8IAF";
        //2nd set of Data
        getData[1][0] = "HDKhWNUb";
        getData[1][1] = "UhFCYySL";
        //3th set of Data
        getData[2][0] = "vQVEAuFS";
        getData[2][1] = "qMA3kwLk";
        return getData;
    }

}
