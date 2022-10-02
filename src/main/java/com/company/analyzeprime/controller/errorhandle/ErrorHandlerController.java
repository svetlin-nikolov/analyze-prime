package com.company.analyzeprime.controller.errorhandle;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.analyzeprime.controller.errorhandle.dto.SimpleFieldErrorDTO;

import springfox.documentation.annotations.ApiIgnore;

/**
 * Error handler class for all rest controllers in the application.
 */
@ApiIgnore
@ControllerAdvice
public class ErrorHandlerController {

	/**
	 * Exception Handler in case of ConstrainViolationException thrown by the validation annotations like Max, Min and so on.
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public ResponseEntity<List<SimpleFieldErrorDTO>> processConstraintViolations(ConstraintViolationException e) {
		List<SimpleFieldErrorDTO> messages = e.getConstraintViolations().stream()
				.map(cv -> new SimpleFieldErrorDTO(cv.getPropertyPath().toString(), cv.getMessage()))
				.collect(Collectors.toList());
		return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);
	}

}