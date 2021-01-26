package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.TestHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInNegativeTestOne extends AbstractTest {


    @Test(dataProvider = "getLogInData", dataProviderClass = TestHelper.class)
    public void logInNegativeTestOne(String username, String password) {
        System.out.println(username + ", " + password);
        homePage.clickSignInButton()
                .signIn(username, password);
        Assert.assertEquals(homePage.getErrorText(), "Invalid username or password");
        homePage.abortLogIn();

    }


}
