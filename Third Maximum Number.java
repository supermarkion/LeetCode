/*
    Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. 
    The time complexity must be in O(n).

    Link: https://leetcode.com/problems/third-maximum-number/

    Example: 
        Example 1:
        Input: [3, 2, 1]

        Output: 1
        Explanation: The third maximum is 1.

        Example 2:
        Input: [1, 2]

        Output: 2
        Explanation: The third maximum does not exist, so the maximum (2) is returned instead.

        Example 3:
        Input: [2, 2, 3, 1]
        Output: 1

        Explanation: Note that the third maximum here means the third maximum distinct number.
        Both numbers with value 2 are both considered as second maximum.

    Solution: None

    Source: https://discuss.leetcode.com/topic/65119/java-solution-using-treeset
*/

public class Solution {
    public final int N = 3;
    public int thirdMax(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (set.size() < N || nums[i] > set.first()) {
                if (set.size() == N) {
                    set.remove(set.first());
                }
                set.add(nums[i]);
            }
        }
        return set.size() == N ? set.first() : set.last();
    }
}