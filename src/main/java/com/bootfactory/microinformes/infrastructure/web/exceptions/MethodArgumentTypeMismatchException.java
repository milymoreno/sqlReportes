package com.bootfactory.microinformes.infrastructure.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MethodArgumentTypeMismatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MethodArgumentTypeMismatchException() {
        super();
    }

    public MethodArgumentTypeMismatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodArgumentTypeMismatchException(String message) {
        super(message);
    }

    public MethodArgumentTypeMismatchException(Throwable cause) {
        super(cause);
    }

}
