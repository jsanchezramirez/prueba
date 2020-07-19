package com.joseangel.prueba.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
public class NotImplementationYet extends RuntimeException {

		public static final long serialVersionUID = 1L;
		
		public NotImplementationYet(@Nullable String s) {
			super(s);
		}
		
		public NotImplementationYet(@Nullable String s, @Nullable Throwable throwable) {
			super(s, throwable);
		}

}
