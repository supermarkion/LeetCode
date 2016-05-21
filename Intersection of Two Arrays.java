/*
    Given two arrays, write a function to compute their intersection.

    Link: https://leetcode.com

    Example: 
    	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
    
    Solution: None

    Source: https://leetcode.com/problems/intersection-of-two-arrays/
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, 1);
        }

        int len = 0;
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) == 1) {
                map.put(num, 2);
                ++len;
            }
        }

        int[] nums = new int[len];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2) {
                nums[i++] = entry.getKey();
            }
        }
        return nums;
    }
}