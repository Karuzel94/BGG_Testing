package com.boardgamegeek.tests;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends BaseTest {


    @Test
    public void RegistrationTest() throws InterruptedException {

        String userName = randomString(8, true, false);
        String userMail = randomString(6, true, true) + "@gmail.com";
        String password = randomString(8, true, true);

        home.clickJoinIn();
        join.registerAccount(userName, userMail, password);

        System.out.println("Registered user is: " + logged.loggedUser());

        System.out.println("NEW ACCOUNT DATA BELOW!!!");
        System.out.println("Username: " + userName);
        System.out.println("Mail: " + userMail);
        System.out.println("Password: " + password);

        assertThat(userName).isEqualTo(logged.loggedUser());

    }

}
