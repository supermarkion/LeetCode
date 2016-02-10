/*
   Given a set of distinct integers, nums, return all possible subsets. 
		Elements in a subset must be in non-descending order.
		The solution set must not contain duplicate subsets.

    Link: https://leetcode.com/problems/subsets/
    
    Example: If nums = [1,2,3], a solution is:
		[
		  [3],
		  [1],
		  [2],
		  [1,2,3],
		  [1,3],
		  [2,3],
		  [1,2],
		  []
		]

    Solution: None
    
    Source: None
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    private void dfs(int[] nums, int pos, List<Integer> list, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, i + 1, list, ret);
            list.remove(list.size() - 1);
        }
    }
}