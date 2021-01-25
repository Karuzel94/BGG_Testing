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
        Object[][] getData = new Object[3][2];
        //1st set of Data
        getData[0][0] = "hxHWIJDgaa";
        getData[0][1] = "GkBw8IAF";
        //2nd set of Data
        getData[1][0] = "HDKhWNUb";
        getData[1][1] = "UhFCYySL";
        //3th set of Data
        getData[2][0] = "vQVEAuFS";
        getData[2][1] = "qMA3kwLk";
        return getData;
    }

    @DataProvider
    public Object[][] positiveTestData() {
        /*Object[][] getData1 = new Object[3][2];
        //1st set of Data
        getData1[0][0] = "hxHWIJDg";
        getData1[0][1] = "GkBw8IAF";
        //2nd set of Data
        getData1[1][0] = "HDKhWNUb";
        getData1[1][1] = "UhFCYySL";
        //3th set of Data
        getData1[2][0] = "vQVEAuFS";
        getData1[2][1] = "qMA3kwLk";
        return getData1;*/
        return new Object[][]
        {
            { "hxHWIJDg", "GkBw8IAF" },
            { "HDKhWNUb", "UhFCYySL" },
            { "vQVEAuFS", "qMA3kwLk" }
        };
    }

}
