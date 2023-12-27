package com.humanFriendlyClock.dao;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;


@Component
public class HumanFriendlyClock {
	
	private static final Map<Integer, String> NUMERIC_TO_TEXT = new HashMap<>();

    static {
        NUMERIC_TO_TEXT.put(1, "One");
        NUMERIC_TO_TEXT.put(2, "Two");
        NUMERIC_TO_TEXT.put(3, "Three");
        NUMERIC_TO_TEXT.put(4, "Four");
        NUMERIC_TO_TEXT.put(5, "Five");
        NUMERIC_TO_TEXT.put(6, "Six");
        NUMERIC_TO_TEXT.put(7, "Seven");
        NUMERIC_TO_TEXT.put(8, "Eight");
        NUMERIC_TO_TEXT.put(9, "Nine");
        NUMERIC_TO_TEXT.put(10, "Ten");
        NUMERIC_TO_TEXT.put(11, "Eleven");
        NUMERIC_TO_TEXT.put(12, "Twelve");
        NUMERIC_TO_TEXT.put(13, "One");
        NUMERIC_TO_TEXT.put(14, "Two");
        NUMERIC_TO_TEXT.put(15, "Three");
        NUMERIC_TO_TEXT.put(16, "Four");
        NUMERIC_TO_TEXT.put(17, "Five");
        NUMERIC_TO_TEXT.put(18, "Six");
        NUMERIC_TO_TEXT.put(19, "Seven");
        NUMERIC_TO_TEXT.put(20, "Eight");
        NUMERIC_TO_TEXT.put(21, "Nine");
        NUMERIC_TO_TEXT.put(22, "Ten");
        NUMERIC_TO_TEXT.put(23, "Eleven");
        NUMERIC_TO_TEXT.put(00, "Twelve");
    }

	public String getHumanFriendlyText(LocalTime time) {
        int hour = time.getHour();
        int minute = time.getMinute();

        String[] minutes = {
            "O'clock", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen",
            "Twenty", "TwentyOne", "TwentyTwo", "TwentyThree",
            "TwentyFour", "TwentyFive", "TwentySix", "TwentySeven",
            "TwentyEight", "TwentyNine", "Thirty"
        };

        String direction = "past";

        if (minute > 30) {
            direction = "to";
            minute = 60 - minute;
            hour = (hour + 1) % 12;
        }

        String minuteText = (minute == 0) ? "" : minutes[minute];

        if (minute == 30) {
            return "Half past " + NUMERIC_TO_TEXT.get(hour) + " o'clock";
        } else if (minute == 15 || minute == 45) {
            return "Quarter " + direction + " " + NUMERIC_TO_TEXT.get(hour) + " o'clock";
        } else if (minute == 5 || minute == 55) {
            return minutes[minute] + " " + direction + " " + NUMERIC_TO_TEXT.get(hour) + " o'clock";
        } else if (minute == 0) {
            return NUMERIC_TO_TEXT.get(hour)+ " o'clock" + " " + minuteText;
        } else {
            return minuteText + " " + direction + " " + NUMERIC_TO_TEXT.get(hour) + " o'clock";
        }
    }   
}
