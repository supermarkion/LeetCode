/*
	Given an array and a value, remove all instances of that value in place and return the new length. The order of elements 
	can be changed. It doesn't matter what you leave beyond the new length.

    Link: https://leetcode.com/problems/remove-element/

    Example: None

    Solution: Swap method to solve this problem. In this problem, consider of that there is no need to worry about the order of 
    new list, then we just change the first value which is equal to elem from the last value of list. This can be assumed as a 
    kind of partition. Then, the return int will be used to divided original list into two parts, and first part is list which 
    remove all elements.

    Source: None
*/

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                --i;
                --n;
            }
        }
        return n;
    }
}