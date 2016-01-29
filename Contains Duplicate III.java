/*
    Given an array of integers, find out whether there are two distinct indices i and j in the array such that the difference between nums[i] 
    and nums[j] is at most t and the difference between i and j is at most k.
    
    Link: https://leetcode.com/problems/contains-duplicate-iii/

    Example: None

    Solution: Sometimes, we can divided problems into large size and small size, then find best solutions.
    
    Source: https://leetcode.com/discuss/78081/time-complexity-solution-using-hashmap-boost-speed-when-large
*/

public class Solution {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (t < 10) {
            //when t is small, the following code runs in O(nt) time, this
            //will be much faster than the naive solution when k is large.
    
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < nums.length; i++) {
                for (int j = -t; j <= t; j++) {
                    int numToFind = nums[i] + j;
                    Integer lastIndex = map.get(numToFind);
                    if (lastIndex != null && lastIndex.intValue() + k >= i) {
                        return true;
                    }
                }
                map.put(nums[i], i);
            }
            return false;
        } else {
            //the naive solution: iteratively check all indices with difference not larger than k
            //Time complexity is O(nk), OK when k is small.
            for (int i = 0; i < nums.length - k; i++) {
                for (int j = i + 1; j <= i + k; j++) {
                    if (nums[i] - nums[j] >= -t && nums[i] - nums[j] <= t) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    
}