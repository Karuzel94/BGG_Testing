package com.boardgamegeek.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

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


    // learning of dataprovider
    /*@DataProvider(name = "loginTestData")
    public Object[][] getLogInData(Method m) {
        if (m.getName().equalsIgnoreCase("testMethodA")) {
            return new Object[3][2]{
                    {"bggtest1221", "bggtest1221"};
                    {"bggtesting122","bggtesting122"}
            }
        }
    }*/
    @DataProvider
    public Object[][] getLogInData(){

        Object[][] getData = new Object[3][2];
        //1st set of Data
        getData[0][0] = "bggtest1221";
        getData[0][1] = "bggtest1221";
        //2nd set of Data
        getData[1][0] = "bggtesting122";
        getData[1][1] = "bggtesting122";
        //3rd set of Data
        getData[2][0] = "bggtest1221";
        getData[2][1] = "bggtest1221";
        return getData;
    }

}
