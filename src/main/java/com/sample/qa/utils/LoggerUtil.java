package com.sample.qa.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by kasunalwis on 12/27/18.
 */
public class LoggerUtil {
    private static Logger logger = Logger.getAnonymousLogger();

    public LoggerUtil() {
    }

    public static void logINFO(String logMessage) {
        logger.log(Level.INFO, logMessage);
    }

    public static void logERROR(String logMessage, Throwable throwable) {
        if(throwable != null) {
            logger.log(Level.SEVERE, logMessage, throwable);
        } else {
            logger.log(Level.SEVERE, logMessage);
        }

    }

    public static void logWARNING(String logMessage, Throwable throwable) {
        if(throwable != null) {
            logger.log(Level.WARNING, logMessage, throwable);
        } else {
            logger.log(Level.WARNING, logMessage);
        }

    }
}
