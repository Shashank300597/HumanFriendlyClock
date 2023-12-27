package com.humanFriendlyClock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humanFriendlyClock.service.TalkingClockService;

@RestController
@RequestMapping("/talking-clock")
public class HumanFriendlyClockController { 

	@Autowired
	private TalkingClockService service;

	@GetMapping("/current-time")
	public ResponseEntity<String> getTalkingClock() {
		return new ResponseEntity<String>(service.getCurrentTimeInText(), HttpStatus.OK);
	}

	@GetMapping("/custom-time/{time}")
	public ResponseEntity<String> getTalkingClock(@PathVariable String time) {
		return new ResponseEntity<String>(service.convertToHumanFriendlyText(time), HttpStatus.ACCEPTED);
	}

}
