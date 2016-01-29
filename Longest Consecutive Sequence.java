/*
    Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

    Link: https://leetcode.com/problems/longest-consecutive-sequence/

    Example: Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. 
    Return its length: 4.

    Solution: None
    
    Source: None
*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int n : nums) {
            set.add(n);
        }
        int lcs = 0;
        for (int n : nums) {
            int i = n, count = 1;
            set.remove(n);
            while (set.contains(--i)) {
                count++;
                set.remove(i);
            }
            i = n;
            while (set.contains(++i)) {
                count++;
                set.remove(i);
            }
            lcs = Math.max(lcs, count);
        }
        return lcs;
    }
}