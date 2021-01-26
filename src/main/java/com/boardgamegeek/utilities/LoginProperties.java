package com.boardgamegeek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginProperties {

    public String loadUsername() throws IOException {

        //File file = new File("C:/Users/Piotrek/IdeaProjects/BGG_Testing/src/main/resources/config.properties");
        FileInputStream propFile = new FileInputStream( "config.properties");
        Properties p = new Properties(System.getProperties());
        p.load(propFile);
        System.setProperties(p);
        String username = p.getProperty("username");
        return username;
    }

    public String loadPassword() throws IOException {
        //File file = new File("C:/Users/Piotrek/IdeaProjects/BGG_Testing/src/main/resources/config.properties");
        FileInputStream propFile = new FileInputStream( "config.properties");
        Properties p = new Properties(System.getProperties());
        p.load(propFile);
        System.setProperties(p);
        String password = p.getProperty("password");
        return password;
    }



}
