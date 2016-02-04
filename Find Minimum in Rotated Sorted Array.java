/*
    Suppose a sorted array is rotated at some pivot unknown to you beforehand.

    Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

    Example: (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

    Solution: In this problem, the main task is find its original order based on three points, which are ’start’, ’mid’ and
	’end’. Once the mid greater than end, which means left part of mid index is ordered, then the pivot located
	at right part, and we change start index to mid plus 1. If mid less than end, which means that right part is
	ordered well, then pivot must located at left part. Then, we change our end to mid index. if they are equal,
	we just reduce one step of end index to reduce range. Finally, the minimum number stopped at start index.
    
    Source: None
*/

public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end--;
            }
        }
        
        return nums[start];
    }
}