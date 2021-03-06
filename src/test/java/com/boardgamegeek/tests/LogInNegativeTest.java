package com.boardgamegeek.tests;

import com.boardgamegeek.listener.StepListener;
import com.boardgamegeek.utilities.Log;
import com.boardgamegeek.utilities.TestHelper;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Listeners(StepListener.class)
public class LogInNegativeTest extends BaseTest {

    @Test(dataProvider = "getLogInData", dataProviderClass = TestHelper.class)
    public void logInNegativeTest(String username, String password) {
        Log.logInfo(username + ", " + password);
        signInFragment.clickSignInButton()
                .signIn(username, password);
        Assert.assertEquals(signInFragment.getErrorText(), "Invalid username or password");
        assertThat(signInFragment.getErrorText()).isEqualTo("Invalid username or password");
        signInFragment.abortLogIn();
    }
}
