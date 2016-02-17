/*
    Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
		Formally the function should:
			Return true if there exists i, j, k 
			such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
    
    Link: https://leetcode.com/problems/increasing-triplet-subsequence/

    Example:
		Given [1, 2, 3, 4, 5], return true.
		Given [5, 4, 3, 2, 1], return false.

    Solution: We must notice that we can save current small and mediem value, and once meet max value, return true.
    
    Source: None
*/

public class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
        int i = 0;

        while (i < nums.length) {
           if (nums[i] > max) {
               return true;
           } else if (nums[i] > min) {
               max = nums[i];
           } else {
               min = nums[i];
           }
           i++;
        }
        return false;
    }
}