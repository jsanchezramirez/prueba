package com.joseangel.prueba.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class InvalidInputException extends RuntimeException {

	public static final long serialVersionUID = 1L;
	
	public InvalidInputException(@Nullable String s) {
		super(s);
	}
	
	public InvalidInputException(@Nullable String s, @Nullable Throwable throwable) {
		super(s, throwable);
	}
}
