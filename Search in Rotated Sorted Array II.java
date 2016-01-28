/*
    Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
    
    Link: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

    Example: None

    Solution: None
    
    Source: None
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length- 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                ++left;
            }
        }

        return false;
    }
}