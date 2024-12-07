package com.Apples2Apples.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The LoggerUtil class is a utility class for logging messages using the Java Logger API.
 * It supports logging at different levels (info, warning, error) and ensures that logs are recorded
 * consistently across the application.
 */
public class LoggerUtil {

    private final Logger logger;

    // Private constructor to enforce the singleton pattern
    private LoggerUtil(String className) {
        logger = Logger.getLogger(className);
    }

    /**
     * Static method to get a singleton instance of LoggerUtil for a specific class.
     *
     * @param clazz The class for which the logger instance is needed.
     * @return A LoggerUtil instance for the given class.
     */
    public static LoggerUtil getInstance(Class<?> clazz) {
        return new LoggerUtil(clazz.getName());
    }

    /**
     * Logs an info message.
     *
     * @param message The message to log.
     */
    public void info(String message) {
        logger.log(Level.INFO, message);
    }

    /**
     * Logs a warning message.
     *
     * @param message The message to log.
     */
    public void warn(String message) {
        logger.log(Level.WARNING, message);
    }

    /**
     * Logs an error message.
     *
     * @param message The message to log.
     */
    public void error(String message) {
        logger.log(Level.SEVERE, message);
    }

    /**
     * Logs an error message with exception details.
     *
     * @param message   The error message to log.
     * @param throwable The exception details to log.
     */
    public void error(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }
}
