/*
    Suppose a sorted array is rotated at some pivot unknown to you beforehand. (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
    You are given a target value to search. If found in the array return its index, otherwise return -1. You may assume no 
    duplicate exists in the array.

    Link: https://leetcode.com/problems/search-in-rotated-sorted-array/

    Example: None

    Solution: In this problem, we should draw a picture to analysis the location of our target values. If it exist duplicate 
    numbers, we just add start number to move the location (when mid number equals to start number).

    Source: None
*/

public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[start]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}