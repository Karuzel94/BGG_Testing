package com.boardgamegeek.api;

import com.boardgamegeek.utilities.TestHelper;
import io.restassured.path.xml.XmlPath;
import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class XmlApi {

    protected WebDriver driver;
    public TestHelper testHelper;

    public XmlApi(WebDriver driver) {
        this.driver = driver;
        testHelper = new TestHelper();
    }

    public XmlApi getLanguageDependenceFromXml(String gameId) {
        XmlPath xmlFile = given().get("https://www.boardgamegeek.com/xmlapi/boardgame/" + gameId).xmlPath();
        getMaxValue(gameId);
        testHelper.setOriginalString(xmlFile.
                get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.find{it.@numvotes=='" +
                        testHelper.getTempNumber() + "'}.@value"));
        return this;
    }

    public String getLanguageDependenceFromXmlFile() {
        return testHelper.getOriginalString();
    }

    public XmlApi getMaxValue(String gameId) {
        XmlPath xmlFile = given().get("https://www.boardgamegeek.com/xmlapi/boardgame/" + gameId).xmlPath();
        testHelper.setTempList(xmlFile.
                get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.@numvotes"));
        testHelper.setTempNumber(Collections.max(testHelper.getTempList().stream().map(Integer::parseInt).collect(Collectors.toList())));
        return this;
    }

    public int maxValue() {
        return testHelper.getTempNumber();
    }

}
