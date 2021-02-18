package com.boardgamegeek.xmlRepresentations;

import io.restassured.path.xml.XmlPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class GameXmlFile {

    private List<String> stringList = new ArrayList<>();
    private List<Integer> intList = new ArrayList<>();

    public GameXmlFile() {
    }

    public XmlPath xmlFile(String gameId) {
        XmlPath xmlFile = given().get("https://www.boardgamegeek.com/xmlapi/boardgame/" + gameId).xmlPath();
        return xmlFile;
    }

    public String getLanguageDependenceFromXml(String gameId) {
        return xmlFile(gameId).get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.find{it.@numvotes=='" +
                getMaxValue(gameId) + "'}.@value");
    }

    public int getMaxValue(String gameId) {
        stringList = xmlFile(gameId).
                get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.@numvotes");
        intList = stringList.stream().map(Integer::parseInt).collect(Collectors.toList());
        return Collections.max(intList);
    }

    public int getTotalVotesNumber(String gameId) {
        return Integer.parseInt(xmlFile(gameId).get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.@totalvotes"));
    }
}
