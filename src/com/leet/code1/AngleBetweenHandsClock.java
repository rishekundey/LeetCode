package com.leet.code1;

/*
 * You are given two numbers, hour and minutes. Return the smaller angle (in degrees) formed between the hour and the minute hand of a clock.
 * 
 * Input: hour = 12, minutes = 30
 * Output: 165
 * 
 * Input: hour = 3, minutes = 30
 * Output: 75
 * 
 * Constraints:
 * 
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * 
 * Explanation Video: https://www.youtube.com/watch?v=8jLOx1hD3_o
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 * 
 * Data Structure used: None
 * 
 * Algorithm used: Math
 * 
 */


public class AngleBetweenHandsClock {
	
	public double angleClock(int hour, int minutes) {
		float hourAngle = (float) ((hour*30)+(0.5*minutes));
		float minuteAngle = (float) (6*minutes);
		if(hourAngle-minuteAngle>180) {
            return 360 - Math.abs(hourAngle-minuteAngle);
		} else if (hourAngle - minuteAngle < -180) {
			return 360 - Math.abs(hourAngle - minuteAngle);
		} else {
			return Math.abs(hourAngle - minuteAngle);
		}
		//return ((hourAngle-minuteAngle)>180)?360-Math.abs(hourAngle-minuteAngle):Math.abs(hourAngle-minuteAngle);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AngleBetweenHandsClock abhc = new AngleBetweenHandsClock();
		System.out.println(abhc.angleClock(12, 30));
	}

}
