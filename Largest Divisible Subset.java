/*
    Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) 
    of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.

	If there are multiple solutions, return any subset is fine.
    
    Link: https://leetcode.com/problems/largest-divisible-subset/

    Example: 
    	Example 1:
			nums: [1,2,3]
			Result: [1,2] (of course, [1,3] will also be ok)

		Example 2:
			nums: [1,2,4,8]
			Result: [1,2,4,8]
    
    Solution: None

    Source: https://discuss.leetcode.com/topic/49797/java-61ms-solution-dfs-pruning-with-comments
*/

public class Solution {
    List<Integer> res;
    int[] mem;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        mem = new int[nums.length];
        Arrays.fill(mem, -1);
        res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), 1);
        return res;
    }

    private void helper(int[] nums, int index, List<Integer> curr, int prev) {
        if (curr.size() > res.size()) {
            res = new ArrayList<>(curr);
        }
        for (int i = index; i < nums.length; i++) {
            // prune: for the current value, if it has been visited with a larger
            // set, then skip it
            if (curr.size() > mem[i] && nums[i] % prev == 0) {
                mem[i] = curr.size();
                curr.add(nums[i]);
                helper(nums, i + 1, curr, nums[i]);
                curr.remove(curr.size() - 1); // backtrack
            }
        }
    }
}