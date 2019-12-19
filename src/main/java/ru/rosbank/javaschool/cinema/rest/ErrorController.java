package ru.rosbank.javaschool.cinema.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import ru.rosbank.javaschool.cinema.constant.Errors;
import ru.rosbank.javaschool.cinema.constant.StatusCodes;
import ru.rosbank.javaschool.cinema.dto.ErrorResponseDto;
import ru.rosbank.javaschool.cinema.exception.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ErrorController extends AbstractErrorController {

    private final ErrorAttributes errorAttributes;
    private final String path;

    public ErrorController(ErrorAttributes errorAttributes, @Value("${server.error.path:${error.path:/error}}") String path) {
        super(errorAttributes);
        this.errorAttributes = errorAttributes;
        this.path = path;
    }

    @RequestMapping
    public ResponseEntity<ErrorResponseDto> error(HttpServletRequest request) {
        ServletWebRequest webRequest = new ServletWebRequest(request);
        Throwable error = errorAttributes.getError(webRequest);

        int status = getStatus(request).value();
        String message = Errors.UNKNOWN;

        if (error == null) {
            return ResponseEntity.status(status).body(
                    new ErrorResponseDto(status, message, Collections.emptyMap())
            );
        }
        if (error instanceof FilmNotFoundException) {
            status = StatusCodes.NOT_FOUND;
            message = Errors.NOT_FOUND_FILM;
            return getErrorResponseDtoResponseEntity(error, status, message);
        }
        if (error instanceof SessionNotFoundException) {
            status = StatusCodes.NOT_FOUND;
            message = Errors.NOT_FOUND_SESSION;
            return getErrorResponseDtoResponseEntity(error, status, message);
        }
        if (error instanceof TicketNotFoundException) {
            status = StatusCodes.NOT_FOUND;
            message = Errors.NOT_FOUND_TICKET;
            return getErrorResponseDtoResponseEntity(error, status, message);
        }
        if (error instanceof NullContentTypeException) {
            status = StatusCodes.UNSUPPORTED_MEDIA_TYPE;
            message = Errors.NULL_TYPE;
            return getErrorResponseDtoResponseEntity(error, status, message);
        }
        if (error instanceof UnsupportedFileTypeException) {
            status = StatusCodes.UNSUPPORTED_MEDIA_TYPE;
            message = Errors.NOT_ALLOWED_TYPE;
            return getErrorResponseDtoResponseEntity(error, status, message);
        }
        if (error instanceof FileStorageException) {
            status = StatusCodes.NOT_SAVED;
            message = Errors.NOT_SAVED_FILE;
            return getErrorResponseDtoResponseEntity(error, status, message);
        }
        if (error instanceof MethodArgumentNotValidException) {
            status = StatusCodes.NOT_VALID;
            message = Errors.INVALID;
            final Map<String, List<String>> errors = ((MethodArgumentNotValidException) error)
                    .getBindingResult().getFieldErrors().stream()
                    .collect(
                            Collectors.groupingBy(FieldError::getField,
                                    Collectors.mapping(DefaultMessageSourceResolvable::getDefaultMessage,
                                            Collectors.toList())));
            return getErrorResponseDtoResponseEntity(error, status, message, errors);
        }

        return getErrorResponseDtoResponseEntity(error, status, message);
    }


    private ResponseEntity<ErrorResponseDto> getErrorResponseDtoResponseEntity(Throwable error, int status, String message) {
        error.printStackTrace();
        return ResponseEntity.status(status).body(
                new ErrorResponseDto(status, message, Collections.emptyMap())
        );
    }

    private ResponseEntity<ErrorResponseDto> getErrorResponseDtoResponseEntity(Throwable error, int status, String message, Map<String, List<String>> errors) {
        error.printStackTrace();
        return ResponseEntity.status(status).body(
                new ErrorResponseDto(status, message, errors)
        );
    }

    @Override
    public String getErrorPath() {
        return path;
    }
}
