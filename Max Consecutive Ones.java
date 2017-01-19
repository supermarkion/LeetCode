/*
    Given a binary array, find the maximum number of consecutive 1s in this array.

    Link: https://leetcode.com/problems/max-consecutive-ones/

    Example: 

        Input: [1,1,0,1,1,1]
        Output: 3
        Explanation: The first two digits or the last three digits are consecutive 1s.
            The maximum number of consecutive 1s is 3.

    Solution: None

    Source: https://discuss.leetcode.com/topic/75921/8ms-java-o-n-solution
*/

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int prevIndex = -1;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                int diff = i - prevIndex -1;
                maxLength = Math.max(maxLength, diff);
                prevIndex = i;
            }
        }
        maxLength = Math.max(maxLength, len - prevIndex - 1);
        return maxLength;
    }
}