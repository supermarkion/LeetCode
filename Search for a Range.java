/*
    Given a sorted array of integers, find the starting and ending position of a given target value. Your algorithm's runtime 
    complexity must be in the order of O(log n). If the target is not found in the array, return [-1, -1].

    Link: https://leetcode.com/problems/search-for-a-range/

    Example: For example, Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4]

    Solution: None
    
    Source: None
*/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int start = 0;
        int end = nums.length - 1;
    
        while (end >= start) {
            int mid = start + (end - start) / 2;
    
            if (nums[mid] == target) {
                int i = mid;
                int j = mid;
    
                while(i > 0 && nums[i - 1] == target) {
                    i--;
                }
    
                while(j < nums.length - 1 && nums[j + 1] == target) {
                    j++;
                }
                
                result[0] = i;
                result[1] = j;
                start = end + 1;
    
            } else if (nums[mid] > target) {
                end = mid - 1;
    
            } else if (nums[mid] < target) {
                start = mid + 1;
            }
        }
    
        return result;
    }
}