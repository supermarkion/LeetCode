/*
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

    Link: https://leetcode.com/problems/range-sum-query-immutable/

    Example: Example:
		Given nums = [-2, 0, 3, -5, 2, -1]
		sumRange(0, 2) -> 1
		sumRange(2, 5) -> -1
		sumRange(0, 5) -> -3

    Solution: Store all range number sum, and when we meet start and end index, minus their sum result.
		    
    Source: https://leetcode.com/discuss/78894/java-easy-version-to-understand
*/

public class NumArray {
    
    int[] nums;
    int[] sum;
    
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        this.nums = nums;
        int len = nums.length;
        sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j] - sum[i] + nums[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);