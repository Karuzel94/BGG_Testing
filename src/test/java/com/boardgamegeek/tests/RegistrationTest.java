package com.boardgamegeek.tests;

import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {


    @Test
    public void RegistrationTest() throws InterruptedException {

        String userName = randomString(8, true, false);
        String userMail = randomString(6, true, true);
        String password = randomString(8, true, true);


        home.clickJoinIn();
        Thread.sleep(6000);

        join.registerAccount(userName, userMail + "@gmail.com", password);






       System.out.println("Registered user is: " + logged.loggedUser());

        System.out.println("NEW ACCOUNT DATA BELOW!!!");
        System.out.println("Username: " + userName);
        System.out.println("Mail: " + userMail + "@gmail.com");
        System.out.println("Password: " + password);



    }

}
