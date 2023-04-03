package anz.backend.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
public class ApiException {
	private final String message;
	private final HttpStatus httpStatus;
	private ZonedDateTime timestamp;
}