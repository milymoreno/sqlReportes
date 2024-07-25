package com.bootfactory.microinformes.infrastructure.web.exceptions;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.bootfactory.microinformes.application.response.GenericResponse;
import com.bootfactory.microinformes.application.response.ResponseBody;
import com.bootfactory.microinformes.infrastructure.messaging.MessageService;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

	@Autowired
	private MessageService messageService;

	@ExceptionHandler(InternalServerException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<CustomErrorResponse> internalServerError(Exception ex, WebRequest request) {
		CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(), messageService.getMessage("exceptions.internal-server"),
				request.getDescription(false));
		return new ResponseEntity<CustomErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public ResponseEntity<CustomErrorResponse> unauthorized(RuntimeException ex, WebRequest request) {
		CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(),
				HttpStatus.UNAUTHORIZED.value(), messageService.getMessage("exceptions.unauthorized"),
				request.getDescription(false));
		return new ResponseEntity<CustomErrorResponse>(errorResponse, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<CustomErrorResponse> notFound(RuntimeException ex, WebRequest request) {
		CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),
				messageService.getMessage("exceptions.resource-not-found"), request.getDescription(false));
		return new ResponseEntity<CustomErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<CustomErrorResponse> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		String error;
		if (ex.getRequiredType().getName().equals("java.time.LocalDate")) {
			String paramName = ex.getName();
			error = messageService.getMessage("exceptions.badDateFormat", new Object[] { paramName },
					LocaleContextHolder.getLocale());
		} else {
			error = ex.getName() + messageService.getMessage("exceptions.bad-request") + ex.getRequiredType().getName();
		}
		CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				error, request.getDescription(false));
		return new ResponseEntity<CustomErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(FactoringBusinessLogicException.class)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ResponseBody> handleFactoringBusinessLogicException(FactoringBusinessLogicException ex,
			WebRequest request) {
		String error = ex.getMessage();
		ResponseBody response = new GenericResponse();
		response.setExitoso(false);
		response.setMensaje(error);
		return new ResponseEntity<ResponseBody>(response, HttpStatus.OK);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<CustomErrorResponse> handleMissingParams(MissingServletRequestParameterException ex,
			WebRequest request) {
		String paramName = ex.getParameterName();
		String errorMessage = messageService.getMessage("exceptions.requiredParam", new Object[] { paramName },
				LocaleContextHolder.getLocale());
		CustomErrorResponse errorResponse = new CustomErrorResponse(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
				errorMessage, request.getDescription(false));
		return new ResponseEntity<CustomErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
