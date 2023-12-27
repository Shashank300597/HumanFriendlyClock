package com.humanFriendlyClock.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.time.LocalTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.humanFriendlyClock.ExceptionHandler.IncorrectInputException;
import com.humanFriendlyClock.dao.HumanFriendlyClock;

@RunWith(MockitoJUnitRunner.class)
public class TalkingClockServiceTest {

	@Mock
	private HumanFriendlyClock humanFriendlyClock;

	@InjectMocks
	private TalkingClockService service;

	@Test 
	public void testGetCurrentTimeInText() {

		LocalTime mockTime = LocalTime.of(13, 25);
		Mockito.when(humanFriendlyClock.getHumanFriendlyText(mockTime)).thenReturn("TwentyFive past One o'clock");

		String actualText =	service.getCurrentTimeInText(); 
		String expectedText = "TwentyFive past One o'clock"; 
		assertEquals(expectedText, actualText); }

	@Test
	public void testConvertToHumanFriendlyTextValidInput() { 

		when(service.convertToHumanFriendlyText("12:30")).thenReturn("Half past Twelve o'clock");
		String expectedText ="Half past Twelve o'clock"; 
		String actualText = service.convertToHumanFriendlyText("12:30");
		assertEquals(expectedText, actualText); 
	}

	@Test(expected = IncorrectInputException.class) 
	public void	testConvertToHumanFriendlyTextInvalidInput() { 
		IncorrectInputException exception = assertThrows(IncorrectInputException.class, () -> {
            service.convertToHumanFriendlyText("25:25");
        });
		assertEquals(exception.getErrorMessage(), "Please enter valid time in 24Hour clock HH:MM format");
	}

}
