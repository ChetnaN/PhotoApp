package com.photoApp.app.ws.mobile.app.ws.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.photoApp.app.ws.mobile.app.ws.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler {
	private static final long serialVersionUID = 1L;

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex) {
		String errorMessage = (ex.getLocalizedMessage() == null) ? "Error Occurred!!!" : ex.getLocalizedMessage().toString();
		ErrorMessage errorMessageObject = new ErrorMessage(new Date(), errorMessage );
		return new ResponseEntity<>(errorMessageObject, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerException(NullPointerException ex) {
		String errorMessage = (ex.getLocalizedMessage() == null) ? "NullPointerException Occurred!!!" : ex.getLocalizedMessage().toString();
		ErrorMessage errorMessageObject = new ErrorMessage(new Date(), errorMessage );
		return new ResponseEntity<>(errorMessageObject, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {UserServiceException.class})
	public ResponseEntity<Object> handleUserServiceException(UserServiceException ex) {
		String errorMessage = (ex.getLocalizedMessage() == null) ? "UserServiceException Occurred!!!" : ex.getLocalizedMessage().toString();
		ErrorMessage errorMessageObject = new ErrorMessage(new Date(), errorMessage );
		return new ResponseEntity<>(errorMessageObject, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
