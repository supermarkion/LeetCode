/*
    Given an array of integers, find two numbers such that they add up to a specific target number. The function twoSum 
    should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
    Please note that your returned answers (both index1 and index2) are not zero-based. You may assume that each input 
    would have exactly one solution.

    Link: https://leetcode.com/problems/two-sum/

    Example: 
   		Input: numbers={2, 7, 11, 15}, target=9
		Output: index1=1, index2=2

    Solution: Standary map to save sum difference, and access the map to find sum result quickly.
    
    Source: None
*/

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int len = nums.length;
        int[] result= new int[2];
        for (int i = 0; i < len; i++) {
            if (map.get(target - nums[i]) != null) {
                result[0] = map.get(target - nums[i]);
                result[1] = i + 1;
                return result;
            } else {
                map.put(nums[i], i + 1);  
            }
        }
        return new int[0];   
    }
}
