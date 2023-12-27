package com.humanFriendlyClock.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class HumanFriendlyClockTest {
	
	@Test
    public void testHalfPast() {
        LocalTime time = LocalTime.of(02, 30);
        String expected = "Half past Two o'clock";
        String actual = new HumanFriendlyClock().getHumanFriendlyText(time);
        assertEquals(expected, actual);
    }

    @Test
    public void testQuarterPast() {
        LocalTime time = LocalTime.of(13, 15);
        String expected = "Quarter past One o'clock";
        String actual = new HumanFriendlyClock().getHumanFriendlyText(time);
        assertEquals(expected, actual);
    }

    @Test
    public void testQuarterTo() {
        LocalTime time = LocalTime.of(05, 45);
        String expected = "Quarter to Six o'clock";
        String actual = new HumanFriendlyClock().getHumanFriendlyText(time);
        assertEquals(expected, actual);
    }

    @Test
    public void testFivePast() {
        LocalTime time = LocalTime.of(07, 05);
        String expected = "Five past Seven o'clock";
        String actual = new HumanFriendlyClock().getHumanFriendlyText(time);
        assertEquals(expected, actual);
    }

    @Test
    public void testFiveTo() {
        LocalTime time = LocalTime.of(13, 55);
        String expected = "Five to Two o'clock";
        String actual = new HumanFriendlyClock().getHumanFriendlyText(time);
        assertEquals(expected, actual);
    }

    @Test
    public void testRandomTime() {
        LocalTime time = LocalTime.of(21, 42);
        String expected = "Eighteen to Ten o'clock";
        String actual = new HumanFriendlyClock().getHumanFriendlyText(time);
        assertEquals(expected, actual);
    }

}
