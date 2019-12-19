package ru.rosbank.javaschool.cinema.constant;

public class Errors {

    private Errors() {
    }

    public static final String UNKNOWN = "error.unknown";

    public static final String INVALID = "error.validation";
    public static final String MIN_VALUE_FILM_ID = "error.validation.min_value.film_id";
    public static final String MIN_VALUE_FILM_TITLE = "error.validation.min_value.film_title";
    public static final String MAX_VALUE_FILM_TITLE = "error.validation.max_value.film_title";
    public static final String NULL_VALUE_FILM_TITLE = "error.validation.null_value.film_title";
    public static final String MAX_VALUE_FILM_DESCRIPTION = "error.validation.max_value.film_description";
    public static final String NULL_VALUE_FILM_DESCRIPTION = "error.validation.null_value.film_description";
    public static final String EMPTY_VALUE_GENRES_LIST = "error.validation.empty_list.film_genres";
    public static final String NULL_VALUE_GENRES_LIST = "error.validation.null_value.film_genres";

    public static final String MIN_VALUE_SESSION_ID = "error.validation.min_value.session_id";
    public static final String MIN_VALUE_SESSION_HALL_NUMBER = "error.validation.min_value.session_hall_number";
    public static final String MAX_VALUE_SESSION_HALL_NUMBER = "error.validation.max_value.session_hall_number";
    public static final String MIN_VALUE_SESSION_DATE = "error.validation.min_value.session_date";
    public static final String MIN_VALUE_SESSION_PRICE = "error.validation.min_value.session_price";

    public static final String NOT_FOUND_FILM = "error.exception.film_not_found";
    public static final String NOT_FOUND_SESSION = "error.exception.session_not_found";
    public static final String NOT_FOUND_TICKET = "error.exception.ticket_not_found";

    public static final String NOT_SAVED_FILE ="error.exception.file_storage_error";
    public static final String NOT_ALLOWED_TYPE = "error.exception.file_unsupported_type";
    public static final String NULL_TYPE = "error.exception.file_null_content_type";

}
