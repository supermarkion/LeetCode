/*
   	Given an array with n objects colored red, white or blue, sort them so that objects of the same color are 
   	adjacent, with the colors in the order red, white and blue. Here, we will use the integers 0, 1, and 2 to 
   	represent the color red, white, and blue respectively.

    Link: https://leetcode.com/problems/sort-colors/
    
    Example: None

    Solution: None
    
    Source: None
*/

public class Solution {
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, right, i);
                right--;
            }
        }
    }
}