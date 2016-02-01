/*
    Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at 
    least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

    Link: https://leetcode.com/problems/find-the-duplicate-number/

    Example: None

    Solution: http://bookshadow.com/weblog/2015/09/28/leetcode-find-duplicate-number/
    
    Source: https://leetcode.com/discuss/74367/java-easy-version-to-understand
*/

public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length == 0 || nums == null) {
        	return 0;
        }
        int low = 1, high = nums.length - 1, mid;
        while (low < high) {
            mid = low + (high - low) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                	count++;
                }
            }
            if (count > mid) {
            	high = mid;
            } else {
            	low = mid + 1;
            }
                
        }
        return low;
    }
}