/*
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
	Each element in the array represents your maximum jump length at that position.
	Your goal is to reach the last index in the minimum number of jumps.

    Link: https://leetcode.com/problems/jump-game-ii/

    Example: Given array A = [2,3,1,1,4]. The minimum number of jumps to reach the last index is 2. 
    (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

    Solution: In the jump game, we should consider that whether the current index is smaller than farthest available index,
	and if this current index available range plus its location is greater than farthest available index, which means
	that we can move to this index to get farther locations. Therefore, we move to this index. When we achieve
	the farthest index, if it is greater than end of list, we achieve the end of list.
    
    Source: None
*/

public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0, jumps = 0;
        while (end < nums.length - 1) {
            int farthest = end;
            // forsee the future condition
            for (int i = start; i <= end; i++) {
                if (i + nums[i] >= farthest) {
                    farthest = i + nums[i];
                }
            }
            if (end < farthest) {
                jumps++;
                start = end + 1;
                end = farthest;
            } else {
                return -1;
            }
        }
        return jumps;
    }
}