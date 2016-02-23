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
    
    Source: None
*/