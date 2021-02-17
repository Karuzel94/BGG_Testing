package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;

import java.util.Collections;
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
        testHelper.setTempString(gamePage.getLanguageDependenceInformation());
        Log.logInfo(testHelper.getTempString() + "________" + gamePage.getGameTitle());
        XmlPath xmlFile = given().get("https://www.boardgamegeek.com/xmlapi/boardgame/" + gamePage.getGameId()).xmlPath();
        testHelper.setTempList(xmlFile.get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.@numvotes"));
        testHelper.setTempNumber(Collections.max(testHelper.getTempList().stream().map(Integer::parseInt).collect(Collectors.toList())));
        if (gamePage.getLanguageDependenceInformation() != "(no votes)") {
            Log.logInfo(String.valueOf(testHelper.getTempNumber()));
            testHelper.setOriginalString(xmlFile.
                    get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.find{it.@numvotes=='" +
                            testHelper.getTempNumber() + "'}.@value"));
            assertThat(testHelper.getOriginalString()).isEqualTo(testHelper.getTempString());
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
        testHelper.setTempString(gamePage.getLanguageDependenceInformation());
        Log.logInfo(testHelper.getTempString() + "________" + gamePage.getGameTitle());
        XmlPath xmlFile = given().get("https://www.boardgamegeek.com/xmlapi/boardgame/" + gamePage.getGameId()).xmlPath();
        testHelper.setTempList(xmlFile.
                get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.@numvotes"));
        testHelper.setTempNumber(Collections.max(testHelper.getTempList().stream().map(Integer::parseInt).collect(Collectors.toList())));
        if (gamePage.getLanguageDependenceInformation() != "(no votes)") {
            given().
                    when().
                    post("https://www.boardgamegeek.com/xmlapi/boardgame/" + gamePage.getGameId()).
                    then().
                    body("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.find{it.@numvotes=='" +
                            testHelper.getTempNumber() + "'}.@value", equalTo(testHelper.getTempString()));
        } else {
            Log.logInfo("There are no language dependence suggestions for game " + gamePage.getGameTitle() + "." +
                    "The test ends now.");
        }
    }
}