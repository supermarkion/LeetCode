/*
    Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
    
    Link: https://leetcode.com/problems/combination-sum/

    Example: given candidate set 2,3,6,7 and target 7, 
		A solution set is: 
		[7] 
		[2, 2, 3] 

    Solution: None
    
    Source: None
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List <List <Integer>> result = new ArrayList<List<Integer>>() ;
        List <Integer> list = new ArrayList<Integer>() ;
        if (candidates == null) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, 0, target, list, result);
        return result;
    }
        
    private void helper (int[] candidates, int pos, int gap, List<Integer>list,
        List<List<Integer>> result) {
        if (gap == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = pos; i < candidates.length; i++) {
            if (gap < candidates[i]) {
                return;
            }
            list.add(candidates[i]);
            helper(candidates, i, gap - candidates[i], list, result);
            list.remove(list.size() - 1);
        }
    }
}