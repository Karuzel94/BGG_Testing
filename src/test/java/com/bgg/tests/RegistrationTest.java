package com.bgg.tests;

import org.testng.annotations.Test;

public class RegistrationTest extends AbstractTest{

    public static String randomString(int len) {
        char[] str = new char[100];
        for (int i = 0; i < len; i++) {
            str[i] = (char) (((int) (Math.random() * 26)) + (int) 'a');
        }
        return (new String(str, 0, len));
    }

    @Test
    public void RegistrationTest () {

        String userName = randomString(8);
        String userMail = randomString(6);
        String passwd = randomString(8);

    }

}
