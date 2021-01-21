package com.boardgamegeek.tests;

import org.testng.annotations.Test;

public class OpenPageTest extends BaseTest {

    @Test
    public void OpenPageTest() {
        System.out.println("Displayed page: " + driver.getTitle());
    }


}
