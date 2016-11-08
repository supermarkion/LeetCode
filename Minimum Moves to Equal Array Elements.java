/*
    Given a non-empty integer array of size n, find the minimum number of moves required to make all array 
    elements equal, where a move is incrementing n - 1 elements by 1.

    Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements/

    Example: 
        Input:
        [1,2,3]

        Output:
        3

        Explanation:
        Only three moves are needed (remember each move increments two elements):

        [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

    Solution: None

    Source: https://discuss.leetcode.com/topic/66812/simple-java-o-n-solution-using-recursion
*/

public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Arrays.sort(nums);
        return helper(nums, 1, nums[0]);
    }
    
    public int helper(int[] nums, int i, int min) {
        return (i >= nums.length) ? 0 : nums[i] - min + helper(nums, ++i, min);
    }
}