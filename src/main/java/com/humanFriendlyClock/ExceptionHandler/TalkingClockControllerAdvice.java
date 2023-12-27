package com.humanFriendlyClock.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TalkingClockControllerAdvice {

	@ExceptionHandler(IncorrectInputException.class)
	private ResponseEntity<String> handleIncorrectInputs(IncorrectInputException incorrectInput){
		return new ResponseEntity<String>(incorrectInput.getErrorMessage(), HttpStatus.BAD_REQUEST);
	}

}
