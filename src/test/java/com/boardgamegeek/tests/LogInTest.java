package com.boardgamegeek.tests;

import org.assertj.core.api.AbstractStringAssert;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIOException;

public class LogInTest extends BaseTest {


    @Test
    public void LogInTest () {

        home.clickSignIn();
        home.signIn(logInData,logInData);
        home.confirmSignIn();

        assertThat(logInData).isEqualTo(logged.loggedUser());

        System.out.println("Logged user: " + logged.loggedUser());

    }

}
