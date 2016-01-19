/*
    Given an unsorted integer array, find the first missing positive integer.

    Link: https://leetcode.com/problems/first-missing-positive/

    Example: 
    	Given [1,2,0] return 3,
		and [3,4,-1,1] return 2.

    Solution: This is not similar to find first missing number because the numbers in this list are not all positive. 
    Moreover, it also has the problem on memory usage. Then, we perform bucket sort, and find the first value which not
    fulfil the equation that value = index + 1. In this process, we use a definition that the sorted value should
    located at index that value minus one. Then, if we meet a value which are not in its suitable location, we
    change it to its suitable location (assume the list have enough space).

    Source: None
*/

public class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && 
                (nums[i] != i + 1) && (nums[i] != nums[nums[i] - 1])) {
				// simple sort
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1; // if not missing, we assign length + 1 is first missing one
    }
}