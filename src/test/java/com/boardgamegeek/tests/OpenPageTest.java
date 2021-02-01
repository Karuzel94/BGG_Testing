package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

public class OpenPageTest extends BaseTest {

    @Test
    public void openPageTest() {
        Log.logInfo("Displayed page: " + driver.getTitle());
    }
}
