package com.boardgamegeek.tests;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends BaseTest {

    @Test
    public void registrationTest() {
        homePage.clickJoinInButton();
        joinPage.registerAccount(testHelper.userName, testHelper.userMail, testHelper.password);
        System.out.println("Registered user is: " + loggedHomePage.getLoggedUserLogin());
        System.out.println("NEW ACCOUNT DATA BELOW!!!");
        System.out.println("Username: " + testHelper.userName);
        System.out.println("Mail: " + testHelper.userMail);
        System.out.println("Password: " + testHelper.password);
        assertThat(testHelper.userName).isEqualTo(loggedHomePage.getLoggedUserLogin());
    }

}
