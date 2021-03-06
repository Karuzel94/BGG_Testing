package com.boardgamegeek.xmlRepresentations;

import io.restassured.path.xml.XmlPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class GameXmlFile {

    private List<String> stringList = new ArrayList<>();

    public XmlPath xmlFile(String gameId) {
        return given().get("https://www.boardgamegeek.com/xmlapi/boardgame/" + gameId).xmlPath();
    }

    public int getMaxValue(String gameId) {
        stringList = xmlFile(gameId).
                get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.@numvotes");
        return Collections.max(stringList.stream().map(Integer::parseInt).collect(Collectors.toList()));
    }

    public String getLanguageDependenceFromXml(String gameId) {
        return (getMaxValue(gameId) == 0) ? "(no votes)" : xmlFile(gameId)
                .get("boardgames.boardgame.poll.find{it.@name=='language_dependence'}.results.result.find{it.@numvotes=='"
                        + getMaxValue(gameId) + "'}.@value");
    }

}
