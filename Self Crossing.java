/*
    You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, 
    then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, 
    after each move your direction changes counter-clockwise. Write a one-pass algorithm with O(1) extra space 
    to determine, if your path crosses itself, or not.

    Link: https://leetcode.com/problems/self-crossing/

    Example:
	    Example 1:
		Given x = [2, 1, 1, 2]
		Return true (self crossing)
		Example 2:
		Given x = [1, 2, 3, 4]
		Return false (not self crossing)
		Example 3:
		Given x = [1, 1, 1, 1]
		Return true (self crossing)

    Solution: We can classified the path movement by four different sub-class based on relationship between N and 
    S, E and W. Note, when W is less than E, we use E - W as measurment to compare with new W.
    
    Source: https://leetcode.com/discuss/88054/java-oms-with-explanation
*/

public class Solution {
    
    public boolean isSelfCrossing(int[] x) {
        for (int i = 3; i<x.length; i++) {
	        if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
	        	return true;  // Case 1: current line crosses the line 3 steps ahead of it
	        } else if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
	        	return true; // Case 2: current line crosses the line 4 steps ahead of it
	        } else if (i >= 5 && x[i-  2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2] 
	        				&& x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3]) {
	        	return true;  // Case 3: current line crosses the line 6 steps ahead of it
	        } 
    	}
    	return false;
    }
}