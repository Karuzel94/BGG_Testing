package com.boardgamegeek.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Log {

    public static Logger logger = LogManager.getLogger(Log.class);

    public static synchronized void logWarn(String string) {
        logger.warn(string);
    }

    public static synchronized void logDebug(String string) {
        logger.debug(string);
    }

    public static synchronized void logError(String string) {
        logger.error(string);
    }

    public static synchronized void logInfo(String string) {
        logger.info(string);
    }

}
