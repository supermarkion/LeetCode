/*
    After robbing those houses on that street, the thief has found himself a new place for his thievery 
    so that he will not get too much attention. This time, all houses at this place are arranged in a 
    circle. That means the first house is the neighbor of the last one. Meanwhile, the security system 
    for these houses remain the same as for those in the previous street.
	Given a list of non-negative integers representing the amount of money of each house, determine 
	the maximum amount of money you can rob tonight without alerting the police.
    
    Link: https://leetcode.com/problems/house-robber-ii/

    Example: None

    Solution: None
    
    Source: https://leetcode.com/discuss/83352/o-n-time-o-1-space-java-dp-solution
*/

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return 0;
        }
        int size = nums.length;
        if(size == 1) {
        	return nums[0];
        }
        if(size == 2) {
        	return Math.max(nums[0], nums[1]);
        }
        // then, we compare miss last one keep first one / miss first one keep last one.
        return Math.max(robHelper(nums, 0, size - 2), robHelper(nums, 1, size - 1));
    }
    private int robHelper(int[] nums, int start, int end){
        int minusTwo = nums[start]; // we also compare keep first one, or miss first one
        int minusOne = Math.max(nums[start], nums[start + 1]);

        for (int i = start + 2; i <= end; i++){
            int current;
            if(minusTwo + nums[i] > minusOne){
                current = minusTwo + nums[i];
	        } else {
	        	current = minusOne;
	        }
            minusTwo = minusOne;
            minusOne = current;
        }
        return minusOne;
    }
}