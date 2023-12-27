package com.humanFriendlyClock.service;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanFriendlyClock.ExceptionHandler.IncorrectInputException;
import com.humanFriendlyClock.dao.HumanFriendlyClock;

@Service
public class TalkingClockService {
	
	@Autowired
	private HumanFriendlyClock humanFriendlyClock;
	
	private static final String TIME_24HOURS_REGEX = "^(?:[01]\\d|2[0-3]):[0-5]\\d$";

	public String getCurrentTimeInText() {
		LocalTime currentTime = LocalTime.now();
		return humanFriendlyClock.getHumanFriendlyText(currentTime);
	}

	public String convertToHumanFriendlyText(String numericTime){

		if(!numericTime.matches(TIME_24HOURS_REGEX)) {
			throw new IncorrectInputException("601", "Please enter valid time in 24Hour clock HH:MM format");
		} else {
			LocalTime time = LocalTime.parse(numericTime);
			return humanFriendlyClock.getHumanFriendlyText(time);
		}
	}

}
