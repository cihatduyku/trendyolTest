package com.cihat.trendyol.logger;

import org.apache.log4j.Logger;

public class Log {
    private static Logger logger = Logger.getLogger(Log.class.getSimpleName());


    public static void info(String message) {
        logger.info(message);
    }
    public static void warn(String message) {
        logger.warn(message);
    }
    public static void debug(String message) {
        logger.debug(message);
    }
    public static void error(String message,Throwable data) {
        logger.error(message,data);
    }

}
