/*
    Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. \
    You may assume that each input would have exactly one solution.
    
    Link: https://leetcode.com/problems/3sum-closest/

    Example: For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

    Solution: None
    
    Source: None
*/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        if (nums.length < 3) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        int temp = 0;
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                temp = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - result) > Math.abs(target - temp)) {
                    result = temp;
                }
                if (result == target) {
                    return result;
                }
                if (temp > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }
}