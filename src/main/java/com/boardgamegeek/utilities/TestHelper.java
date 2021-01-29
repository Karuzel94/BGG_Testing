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

    private final String userName = randomString(8, true, false);
    private final String userMail = randomString(6, true, true) + "@gmail.com";
    private final String password = randomString(8, true, true);
    private final String firstname = randomString(8, true, false);
    private final String lastname = randomString(8, true, false);
    private final String address = randomString(8, true, false);
    private final String city = randomString(8, true, false);
    private final String newState = randomString(8, true, false);
    private final String zipCode = randomString(5, false, true);
    private final String website = randomString(8, true, true);
    private final String phoneNumber = randomString(9, false, true);
    private final String xboxTag = randomString(8, true, true);
    private final String battlenetAccount = randomString(8, true, true);
    private final String steamAccount = randomString(8, true, true);
    private final String wiiFriendCode = randomString(8, true, true);
    private final String psnId = randomString(8, true, true);
    private final int gameIndex = getRandomNumber(1,100);

    @DataProvider
    public Object[][] getLogInData() {
        return new Object[][]{
                {"hxHWIJDgaa", "GkBw8IAF"},
                {"8HDKhWNU", "UhFCYySL"},
                {"vQVEAuFSasd", "qMA3kwLk"}
        };
    }

    public String getUserName() {
        return userName;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getNewState() {
        return newState;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getWebsiteAddress() {
        return website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getXboxTag() {
        return xboxTag;
    }

    public String getBattlenetAccount() {
        return battlenetAccount;
    }

    public String getSteamAccount() {
        return steamAccount;
    }

    public String getWiiFriendCode() {
        return wiiFriendCode;
    }

    public String getPsnId() {
        return psnId;
    }

    public int getGameIndex() {
        return gameIndex;
    }
}
