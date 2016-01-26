/*
    Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the 
    candidate numbers sums to T. Each number in C may only be used once in the combination.

    Link: https://leetcode.com/problems/combination-sum-ii/

    Example: For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
		A solution set is: 
		[1, 7] 
		[1, 2, 5] 
		[2, 6] 
		[1, 1, 6] 

    Solution: None
    
    Source: None
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, list, result);
        return result;
    }
    private void helper(int[] candidates, int pos, int gap, List<Integer> list, List<List<Integer>> result) {
        if (gap == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (i != pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (gap < candidates[i]) {
                return;
            }
            list.add(candidates[i]);
            helper(candidates, i + 1, gap - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}