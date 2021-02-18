package com.boardgamegeek.tests;

import com.boardgamegeek.utilities.Log;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

public class XmlFetchingTest extends BaseTest {

    @Test
    public void fetchingXmlFileTest() {
        signInFragment.clickSignInButton()
                .signIn(loginProperties.getUsername(), loginProperties.getPassword());
        assertThat(userMenuFragment.getUserName()).isEqualTo(loginProperties.getUsername());
        Log.logInfo("Username: " + loginProperties.getUsername()
                + ", Password:  " + loginProperties.getPassword());
        menuFragment.goToAllBoardgames();
        allBoardgamesPage.goToRandomGame();
        Log.logInfo(gamePage.getGameId());
        assertThat(gameXmlFile.getTotalVotesNumber(gamePage.getGameId())).isNotEqualTo(0);
        assertThat(gameXmlFile.getLanguageDependenceFromXml(gamePage.getGameId())).isEqualTo(gamePage.getLanguageDependenceInformation());
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
        given().
                when().
                post("https://www.boardgamegeek.com/xmlapi/boardgame/" + gamePage.getGameId()).
                then().
                body("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.@totalvotes", greaterThan("0")).
                body("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.find{it.@numvotes=='" +
                        gameXmlFile.getMaxValue(gamePage.getGameId()) + "'}.@value", equalTo(gamePage.getLanguageDependenceInformation()));
    }
}
