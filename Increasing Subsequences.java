/*
    Given an integer array, your task is to find all the different possible increasing subsequences 
    of the given array, and the length of an increasing subsequence should be at least 2 .

    Link: https://leetcode.com/problems/increasing-subsequences/

    Example: 
        Input: [4, 6, 7, 7]
        Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

    Solution: None

    Source: https://discuss.leetcode.com/topic/76249/java-20-lines-backtracking-solution-using-set-beats-100
*/

public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
         Set<List<Integer>> res= new HashSet<List<Integer>>();
         List<Integer> holder = new ArrayList<Integer>();
         findSequence(res, holder, 0, nums);
         List result = new ArrayList(res);
         return result;
     }

    public void findSequence(Set<List<Integer>> res, List<Integer> holder, int index, int[] nums) {
        if (holder.size() >= 2) {
            res.add(new ArrayList(holder));
        }
        for (int i = index; i < nums.length; i++) {
            if(holder.size() == 0 || holder.get(holder.size() - 1) <= nums[i]) {
                holder.add(nums[i]);
                findSequence(res, holder, i + 1, nums);
                holder.remove(holder.size() - 1);
            }
        }
    }
}