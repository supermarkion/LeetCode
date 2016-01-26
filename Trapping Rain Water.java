/*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, 
    compute how much water it is able to trap after raining.

    Link: https://leetcode.com/problems/trapping-rain-water/

    Example: Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

    Solution: We find highest wall, and compute trapping water at left and right.
    
    Source: None
*/

public class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int max = -1;
        int maxIndex = -1;
        int prev;
        // find the highest bar
        for ( int i = 0; i < height.length; i++) {
            if ( max < height[i]) {
                max = height[i];
                maxIndex = i;
            }
        }
        // process all bars left to the highest bar
        prev = 0;
        for (int i = 0; i < maxIndex; i++) {
            if (height[i] > prev) {
                sum += (height[i] - prev) * (maxIndex - i);
                prev = height[i];
                }
            sum -= height[i];
        }
        // process all bars right to the highest bar
        prev = 0;
        for (int i = height.length - 1; i > maxIndex; i--) {
            if (height[i] > prev) {
                sum += (height[i] - prev) * (i - maxIndex);
                prev = height[i];
                }
            sum -= height[i];
        }
        return sum;
    }
}