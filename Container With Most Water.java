/*
    Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
    n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two 
    lines, which together with x-axis forms a container, such that the container contains the most water.

    Link: https://leetcode.com/problems/container-with-most-water/
    Example: None
    Solution: None
    Source: None
*/

public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1, maxArea = Math.min(height[left], height[right]) * (right - left);
        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else if (height[left] < height[right]) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}