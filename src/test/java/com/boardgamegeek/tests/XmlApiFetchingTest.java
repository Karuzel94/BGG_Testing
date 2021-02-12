package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasValue;

public class XmlApiFetchingTest extends BaseTest {

    @Test
    public void fetchingRequestTest() throws InterruptedException {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        Thread.sleep(1000);
        menuFragment.goToAllBoardgames();
        allBoardgamesPage.goToRandomGame();
        String languageDependence = gamePage.getLanguageDependenceInformation();
        Log.logInfo(languageDependence + "________" + gamePage.getGameTitle());
        given()

        .when()

        .then()
                .body("poll.results.result.value", hasValue(languageDependence));

        Log.logInfo(given().when().then().body("poll.results.result", hasValue(languageDependence)).toString());
    }
}