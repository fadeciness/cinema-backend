package ru.rosbank.javaschool.cinema.exception;

public class NullContentTypeException extends RuntimeException {

    public NullContentTypeException() {
    }

    public NullContentTypeException(String message) {
        super(message);
    }

    public NullContentTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullContentTypeException(Throwable cause) {
        super(cause);
    }

    public NullContentTypeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
