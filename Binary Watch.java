/*
    A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
	
	Each LED represents a zero or one, with the least significant bit on the right.
	
	For example, the above binary watch reads "3:25". Given a non-negative integer n which represents the number of LEDs that are currently 
	on, return all possible times the watch could represent.
    
    Link: https://leetcode.com/problems/binary-watch/

    Example: 
		Example:
			Input: n = 1
			Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

    Solution: None

    Source: https://discuss.leetcode.com/topic/59374/simple-python-java
*/

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> times = new ArrayList<>();
	    for (int h = 0; h < 12; h++) {
	    	for (int m = 0; m < 60; m++) {
	    		if (Integer.bitCount(h * 64 + m) == num) {
	            	times.add(String.format("%d:%02d", h, m));
	            }
	    	}
	    }     
	    return times;    
    }
}