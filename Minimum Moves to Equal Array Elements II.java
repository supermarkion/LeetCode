/*
	Given a non-empty integer array, find the minimum number of moves required to make all array elements 
	equal, where a move is incrementing a selected element by 1 or decrementing a selected element by 1.

	You may assume the array's length is at most 10,000.    
    
    Link: https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/

    Example: 

		Input:
			[1,2,3]

		Output:
			2

		Explanation:
			Only two moves are needed (remember each move increments or decrements one element):

		[1,2,3]  =>  [2,2,3]  =>  [2,2,2]
            
    Solution: None

    Source: https://discuss.leetcode.com/topic/68762/java-solution-with-thinking-process
*/

public class Solution {
    public int minMoves2(int[] nums) {
        if (nums==null||  nums.length==0) {
        	return 0;
        }
        long moves = Integer.MAX_VALUE;
        Arrays.sort(nums);
        long totalSum = 0L;
        long sum = 0L;
        for (int i =0;i<nums.length;i++) {
            totalSum += (long)nums[i];
        }
        for(int i =0;i<nums.length;i++) {
            long m = (long)(i - (nums.length - i - 1) - 1) * (long)nums[i] - sum + (totalSum - sum);
            moves = Math.min(m, moves);
            sum += nums[i];
        }
        return (int)moves;
    }
}