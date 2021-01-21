package com.boardgamegeek.tests;

import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {


    @Test
    public void RegistrationTest () {

        String userName = randomString(8, true,true);
        String userMail = randomString(6,true,true);
        String passwd = randomString(8,true,true);

        home.clickJoinIn();
        join.setNewUserName(userName);
        join.setMailInput(userMail + "@gmail.com");
        join.setNewUserPassword(passwd);
        join.createAnAccount();


    }

}
