/*
    Given two arrays, write a function to compute their intersection.

    Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/

    Example: 
    	Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
    
    Solution: None

    Source: http://blog.csdn.net/foreverling/article/details/51451919
*/

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            if (map1.containsKey(num)) {
                map1.put(num, map1.get(num) + 1);
            } else {
                map1.put(num, 1);
            }
        }
 
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int num : nums2) {
            if (map2.containsKey(num)) {
                map2.put(num, map2.get(num) + 1);
            } else {
                map2.put(num, 1);
            }
        }
 
        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            int times = entry.getValue();
            if (map2.containsKey(entry.getKey())) {
                times = Math.min(times, map2.get(entry.getKey()));
            } else {
                times = 0;
            }
            for (int i = 0; i < times; i++) {
                list.add(entry.getKey());
            }
        }
 
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}