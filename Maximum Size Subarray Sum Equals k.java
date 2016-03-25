/*
    Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

    Link: https://leetcode.com/problemset/algorithms/

    Example: 
	    Example 1:
			Given nums = [1, -1, 5, -2, 3], k = 3,
			return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
		Example 2:
			Given nums = [-2, -1, 2, 1], k = 1,
			return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
	
    Solution: None

    Source: http://buttercola.blogspot.com.au/2016/01/leetcode-maximum-size-subarray-sum.html
*/

public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
         
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 
        int sum = 0;
         
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
             
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
        }
         
        return maxLen;
    }
}
