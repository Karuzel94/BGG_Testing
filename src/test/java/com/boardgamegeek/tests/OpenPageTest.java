package com.boardgamegeek.tests;

import org.testng.annotations.Test;

public class OpenPageTest extends AbstractTest {

    @Test
    public void openPageTest() {
        System.out.println("Displayed page: " + driver.getTitle());
    }


}
