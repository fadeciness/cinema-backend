package ru.rosbank.javaschool.cinema.constant;

public class Errors {

    private Errors() {
    }

    public static final String UNKNOWN = "error.unknown";

    public static final String INVALID = "error.validation";
    public static final String MIN_VALUE = "error.validation.min_value";
    public static final String MAX_VALUE = "error.validation.max_value";
    public static final String NULL_VALUE = "error.validation.null_value";
    public static final String EMPTY_VALUE = "error.validation.empty_list";

    public static final String NOT_FOUND_FILM = "error.exception.film_not_found";
    public static final String NOT_FOUND_SESSION = "error.exception.session_not_found";
    public static final String NOT_FOUND_TICKET = "error.exception.ticket_not_found";

    public static final String NOT_SAVED_FILE ="error.exception.file_storage_error";
    public static final String NOT_ALLOWED_TYPE = "error.exception.file_unsupported_type";
    public static final String NULL_TYPE = "error.exception.file_null_content_type";

}
