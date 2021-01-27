package com.boardgamegeek.tests;

import com.boardgamegeek.listener.StepListener;
import com.boardgamegeek.utilities.Log;
import com.boardgamegeek.utilities.TestHelper;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners(StepListener.class)
public class LogInNegativeTestOne extends BaseTest {

    @Test(dataProvider = "getLogInData", dataProviderClass = TestHelper.class)
    public void logInNegativeTestOne(String username, String password) {
        Log.logInfo(username + ", " + password);
        homePage.clickSignInButton()
                .signIn(username, password);
        Assert.assertEquals(homePage.getErrorText(), "Invalid username or password");
        assertThat(homePage.getErrorText()).isEqualTo("Invalid username or password");
        homePage.abortLogIn();
    }
}
