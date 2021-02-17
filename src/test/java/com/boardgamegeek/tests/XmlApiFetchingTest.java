package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class XmlApiFetchingTest extends BaseTest {

    @Test
    public void fetchingXmlFileTest() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername()
                + ", Password:  " + loginProperties.getPassword());
        menuFragment.goToAllBoardgames();
        allBoardgamesPage.goToRandomGame();
        Log.logInfo(gamePage.getLanguageDependenceInformation() + "________" + gamePage.getGameTitle());
        xmlApi.getLanguageDependenceFromXml(gamePage.getGameId());
        if (gamePage.getLanguageDependenceInformation() != "(no votes)") {
            Log.logInfo("xml: " + xmlApi.getLanguageDependenceFromXmlFile());
            Log.logInfo("Game page: " + gamePage.getLanguageDependenceInformation());
            assertThat(xmlApi.getLanguageDependenceFromXmlFile()).isEqualTo(gamePage.getLanguageDependenceInformation());
        } else {
            Log.logInfo("There are no language dependence suggestions for game " + gamePage.getGameTitle() + "." +
                    "The test ends now.");
        }
    }

    @Test
    public void fetchingRequestTest() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername()
                + ", Password:  " + loginProperties.getPassword());
        menuFragment.goToAllBoardgames();
        allBoardgamesPage.goToRandomGame();
        Log.logInfo(testHelper.getTempString() + "________" + gamePage.getGameTitle());
        xmlApi.getMaxValue(gamePage.getGameId());
        if (gamePage.getLanguageDependenceInformation() != "(no votes)") {
            given().
                    when().
                    post("https://www.boardgamegeek.com/xmlapi/boardgame/" + gamePage.getGameId()).
                    then().
                    body("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.find{it.@numvotes=='" +
                            xmlApi.maxValue() + "'}.@value", equalTo(gamePage.getLanguageDependenceInformation()));
        } else {
            Log.logInfo("There are no language dependence suggestions for game " + gamePage.getGameTitle() + "." +
                    "The test ends now.");
        }
    }
}