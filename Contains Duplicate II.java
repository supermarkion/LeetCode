/*
    Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array 
    such that nums[i] = nums[j] and the difference between i and j is at most k.

    Link: https://leetcode.com/problems/contains-duplicate-ii/

    Example: None

    Solution: None
    
    Source: https://leetcode.com/discuss/79895/short-hashset-solution
*/

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hs.add(nums[i]) == false) {
            	return true;
            }
            if (hs.size() == k + 1) {
            	hs.remove(nums[i - k]);
            }
        }
        return false;
    }
}