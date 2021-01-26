package com.boardgamegeek.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class TestHelper {

    public String randomString(int length, boolean isLetters, boolean isNumbers) {
        return RandomStringUtils.random(length, isLetters, isNumbers);
    }

    public String userName = randomString(8, true, false);
    public String userMail = randomString(6, true, true) + "@gmail.com";
    public String password = randomString(8, true, true);
    public String logInUsername = "hxHWIJDg";
    public String logInPassword = "GkBw8IAF";


    @DataProvider
    public Object[][] getLogInData() {
        return new Object[][]{
                { "hxHWIJDgaa", "GkBw8IAF" },
               // { "8HDKhWNU", "UhFCYySL" },
               // { "vQVEAuFSasd", "qMA3kwLk" }
        };
    }


}
