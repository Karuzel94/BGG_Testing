package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        Log.logInfo(driver.getCurrentUrl());
        String gameId = driver.getCurrentUrl().replaceAll("\\D+", "");
        Log.logInfo(gameId);
        String languageDependence = gamePage.getLanguageDependenceInformation();
        Log.logInfo(languageDependence + "________" + gamePage.getGameTitle());
        XmlPath xmlFile = given().get("https://www.boardgamegeek.com/xmlapi/boardgame/" + gameId).xmlPath();
        List<String> numVotesString = xmlFile.
                get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.@numvotes");
        int maxValue = Collections.max(numVotesString.stream().map(Integer::parseInt).collect(Collectors.toList()));
        if (maxValue != 0) {
            Log.logInfo(String.valueOf(maxValue));
            String dependenceFromXml = xmlFile.
                    get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.find{it.@numvotes=='" + maxValue + "'}.@value");
            Log.logInfo(dependenceFromXml);
            assertThat(dependenceFromXml).isEqualTo(languageDependence);
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
        Log.logInfo(driver.getCurrentUrl());
        String gameId = driver.getCurrentUrl().replaceAll("\\D+", "");
        Log.logInfo(gameId);
        String languageDependence = gamePage.getLanguageDependenceInformation();
        Log.logInfo(languageDependence + "________" + gamePage.getGameTitle());
        XmlPath xmlFile = given().get("https://www.boardgamegeek.com/xmlapi/boardgame/" + gameId).xmlPath();
        List<String> numVotesString = xmlFile.
                get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.@numvotes");
        int maxValue = Collections.max(numVotesString.stream().map(Integer::parseInt).collect(Collectors.toList()));
        if (maxValue != 0) {
            Log.logInfo(String.valueOf(maxValue));
            given().
                    when().
                    get("https://www.boardgamegeek.com/xmlapi/boardgame/" + gameId).
                    then().
                    body("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.find{it.@numvotes=='" +
                                    maxValue + "'}.@value", equalTo(languageDependence));
        } else {
            Log.logInfo("There are no language dependence suggestions for game " + gamePage.getGameTitle() + "." +
                    "The test ends now.");
        }
    }
}