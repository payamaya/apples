package com.Apples2Apples.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {

    private final Logger logger;

    // Private constructor to enforce the singleton pattern
    private LoggerUtil(String className) {
        logger = Logger.getLogger(className);
    }

    // Static method to get a singleton instance of LoggerUtil
    public static LoggerUtil getInstance(Class<?> clazz) {
        return new LoggerUtil(clazz.getName());
    }

    // Method to log an info message
    public void info(String message) {
        logger.log(Level.INFO, message);
    }

    // Method to log a warning message
    public void warn(String message) {
        logger.log(Level.WARNING, message);
    }

    // Method to log an error message
    public void error(String message) {
        logger.log(Level.SEVERE, message);
    }

    // Overloaded method to log an error message with exception details
    public void error(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }
}
