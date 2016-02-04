/*
    Rotate an array of n elements to the right by k steps.

    Link: https://leetcode.com/problems/rotate-array/

    Example: 
        For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

    Solution: None
    
    Source: None
*/

public class Solution {
    public void rotate(int[] nums, int k) {
		int[] answer = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			answer[(i + k) % nums.length] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = answer[i];
		}
    }
}