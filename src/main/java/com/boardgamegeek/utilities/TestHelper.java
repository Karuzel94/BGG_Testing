package com.boardgamegeek.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class TestHelper {

    public String randomString(int length, boolean isLetters, boolean isNumbers) {
        return RandomStringUtils.random(length, isLetters, isNumbers);
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String userName = randomString(8, true, false);
    public String userMail = randomString(6, true, true) + "@gmail.com";
    public String password = randomString(8, true, true);
    public String logInData = "bggtest1221";
    public String anotherLogInData = "bggtesting122";


    /* learning of dataprovider
    @DataProvider(name = "loginTestData")
    public Object[][] dpMethod(Method m) {
        if (m.getName().equalsIgnoreCase("testMethodA")) {
            return new Object[][]{
                    {"bggtest1221", "bggtest1221"};
                    {"bggtesting122","bggtesting122"}
            }
        }
    }*/
}
