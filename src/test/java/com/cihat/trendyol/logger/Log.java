package com.cihat.trendyol.logger;

import org.apache.log4j.Logger;

public class Log {
    private static Logger log = Logger.getLogger(Log.class.getSimpleName());


    public static void info(String message) {
        log.info(message);
    }
    public static void warn(String message) {
        log.warn(message);
    }
    public static void debug(String message) {
        log.debug(message);
    }
    public static void error(String message,Throwable data) {
        log.error(message,data);
    }

}
