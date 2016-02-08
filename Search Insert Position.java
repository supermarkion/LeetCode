/*
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where 
    it would be if it were inserted in order. You may assume no duplicates in the array.

    Link: https://leetcode.com/problems/search-insert-position/

    Example:
	    Here are few examples.
			[1,3,5,6], 5 → 2
			[1,3,5,6], 2 → 1
			[1,3,5,6], 7 → 4
			[1,3,5,6], 0 → 0

    Solution: The classic binary search process. Note: the mid is start + (end − start) ÷ 2. And the start starts from −1 
    and end starts from length of list. And our target index is start plus 1.
    
    Source: None
*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = -1, end = nums.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start + 1;
    }
}