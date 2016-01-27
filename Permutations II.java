/*
    Given a collection of numbers that might contain duplicates, return all possible unique permutations.
    
    Link: https://leetcode.com/problems/permutations-ii/

    Example: 
   		[1,1,2] have the following unique permutations:
		[1,1,2], [1,2,1], and [2,1,1].

    Solution: Given a list of numbers with duplicate number in it. Find all unique permutations. Which means 
    that when we face same number during construction process, we skip this step.
    
    Source: None
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> temp = new ArrayList<Integer>();
        int[] visited = new int[nums.length];
        Arrays.sort(nums);
        permuteUniqueHelper(result, temp, visited, nums);
        return result;
    }
    
    private void permuteUniqueHelper(List<List<Integer>> result, List<Integer> temp, int[] visited, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<Integer>(temp)); // if constructe one step, add to total result
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // if current num has already be used, or duplicated num exits in temp list
            if (visited[i] == 1 || ((i != 0 && nums[i] == nums[i - 1]) && visited[i - 1] == 0)) {
                continue;
            }
            visited[i] = 1;
            temp.add(nums[i]);
            permuteUniqueHelper(result, temp, visited, nums);
            temp.remove(temp.size() - 1);
            visited[i] = 0;
        }
    }
}