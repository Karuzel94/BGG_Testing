package com.boardgamegeek.utilities;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import java.util.*;
import java.util.stream.Collectors;

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
    private final String firstName = randomString(8, true, false);
    private final String lastName = randomString(8, true, false);
    private final String address = randomString(8, true, false);
    private final String city = randomString(8, true, false);
    private final String stateOrProvince = randomString(8, true, false);
    private final String zipCode = randomString(5, false, true);
    private final String websiteOrHomepage = randomString(8, true, true);
    private final String phoneNumber = randomString(9, false, true);
    private final String xBoxTag = randomString(8, true, true);
    private final String battleNetAccount = randomString(8, true, true);
    private final String steamAccount = randomString(8, true, true);
    private final String wiiFriendCode = randomString(8, true, true);
    private final String psnId = randomString(8, true, true);
    private final List<String> country = Arrays.asList("Finland", "Russia", "Poland", "Afghanistan",
            "Azerbaijan", "British Virgin Islands", "United States", "Zimbabwe",
            "Tunisia", "Malaysia");
    private String countryName = country.get(getRandomNumber(0, country.size()));
    private String gameName = "";
    private List<String> titlesList = new ArrayList<>();
    private List<String> tempList = new ArrayList<>();
    private String wishListOption = "";
    private int tempNumber = 0;


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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getWebsiteOrHomepage() {
        return websiteOrHomepage;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getXBoxTag() {
        return xBoxTag;
    }

    public String getBattleNetAccount() {
        return battleNetAccount;
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

    public String getCountry() {
        return countryName;
    }

    public void setCountry(String country) {
        countryName = country;
    }

    public void setGameName(String game) {
        gameName = game;
    }

    public String getGameName() {
        return gameName;
    }

    public void setListOfTitles(List<String> list) {
        titlesList = list;
        Collections.shuffle(titlesList);
        Map<String, String> map = titlesList.stream().collect(Collectors.toMap(String::new, String::new));
        for (Map.Entry<String, String> mapa : map.entrySet()) {
            if (mapa.getValue().startsWith("The ") || mapa.getValue().startsWith("La ")) {
                mapa.setValue(mapa.getValue().substring(mapa.getValue().indexOf(" ") + 1));
            }
        }
        Map<String, String> result2 = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
        titlesList = new ArrayList<>(result2.keySet());
    }

    public List<String> getListOfTitles() {
        return titlesList;
    }

    public void setWishListOption(String option) {
        wishListOption = option.substring(4);
    }

    public String getWishListOption() {
        return wishListOption;
    }

    public void setGamesListWithSelectedWishListOption(List<String> list) {
        list.sort(Comparator.reverseOrder());
        tempList = list;
    }

    public List<String> getGamesListWithSelectedWishListOption() {
        return tempList;
    }

    public int getTempNumber() {
        return tempNumber;
    }

    public void setTempNumber(int tempNumber) {
        this.tempNumber = tempNumber;
    }
}
