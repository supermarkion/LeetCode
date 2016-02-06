/*
	A peak element is an element that is greater than its neighbors. Given an input array where num[i] ≠ num[i+1], find a peak 
	element and return its index. The array may contain multiple peaks, in that case return the index to any one of the peaks 
	is fine. You may imagine that num[-1] = num[n] = -∞.

    Link: https://leetcode.com/problems/find-peak-element/

    Example: For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

    Solution: Swap method to solve this problem. In this problem, consider of that there is no need to worry about the order of 
    new list, then we just change the first value which is equal to elem from the last value of list. This can be assumed as a 
    kind of partition. Then, the return int will be used to divided original list into two parts, and first part is list which 
    remove all elements.

    Source: None
*/

public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1]) {
                start = mid;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else {
                return mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
}