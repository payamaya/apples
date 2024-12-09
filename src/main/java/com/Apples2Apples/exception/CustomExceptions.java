package com.Apples2Apples.exception;

public class CustomExceptions {
    public static class OnlineCommunicationException extends RuntimeException {
        public OnlineCommunicationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    public  class BotLogicException extends RuntimeException {
        public BotLogicException(String message, IllegalArgumentException e) {
            super(message);
        }
    }
    public static class CardReplenishException extends RuntimeException {
        public CardReplenishException(String message) {
            super(message);
        }
    }
    public static class CardSelectionException extends RuntimeException {
        public CardSelectionException(String message) {
            super(message);
        }
    }
    public static class FileDAOException extends RuntimeException {
        public FileDAOException(String message) {
            super(message);
        }

        public FileDAOException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    public static class InvalidGameNotificationException extends RuntimeException {

        public InvalidGameNotificationException(String message) {
            super(message);
        }
    }
    public static class InvalidGameStateException extends RuntimeException {
        public InvalidGameStateException(String message) {
            super(message);
        }
    }
    public static class InvalidPlayerNotificationException extends RuntimeException {

        public InvalidPlayerNotificationException(String message) {
            super(message);
        }
    }
    public static class InvalidTableSizeException extends RuntimeException {
        public InvalidTableSizeException(String message) {
            super(message);
        }
    }
    public static class InvalidUserInputException extends RuntimeException {
        public InvalidUserInputException(String message) {
            super(message);
        }
    }
    public static class JudgeSelectorNotificationException extends RuntimeException {
        public JudgeSelectorNotificationException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    public static class JudgeUtilException extends RuntimeException {
        public JudgeUtilException(String message) {
            super(message);
        }
    }
    public static class NotificationDisplayException extends RuntimeException {
        public NotificationDisplayException(String message) {
            super(message);
        }
        
    }
    public static class SocketStreamException extends RuntimeException {
        public SocketStreamException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    public static class InvalidPlayerCountException extends RuntimeException {
        public InvalidPlayerCountException(String message) {
            super(message);
        }
    }
}
