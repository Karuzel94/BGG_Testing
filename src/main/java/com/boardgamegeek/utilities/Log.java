package com.boardgamegeek.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class Log {

    public static Logger logger = LogManager.getLogger(Log.class);

    public static synchronized void logWarn(){
        logger.warn("Warning.");
    }

    public static synchronized void logDebug(){
        logger.debug("Debugging.");
    }

    public static synchronized void logError(){
        logger.error("error.");
    }

    public static synchronized void logInfo(String string){
        logger.info("info.");
        logger.error("error.");
        logger.debug("Debugging.");
        logger.warn("Warning.");
    }

}
