/*
    Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty 
    continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
    
    Note:
        Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.
    Link: https://leetcode.com/problems/convert-a-number-to-hexadecimal/

    Example: 
		Input:
        nums = [1,2,3,4,5]
        m = 2

        Output:
        9

        Explanation:
        There are four ways to split nums into two subarrays.
        The best way is to split it into [1,2,3] and [4,5],
        where the largest sum among the two subarrays is only 9.

    Solution: None

    Source: https://discuss.leetcode.com/topic/61315/java-easy-binary-search-solution-8ms
*/

public class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for (int num: nums) {
            max = Math.max(max, num);
            sum += num;
        }
        return (int) binary(nums, m, sum, max);
    }
    
    private long binary(int[] nums, int m, long high, long low){
        long mid = 0;
        while (low < high) {
            mid = (high + low) / 2;
            if (valid(nums, m, mid)) {
                //System.out.println(mid);
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
    
    private boolean valid(int[] nums, int m, long max){
        int cur = 0;
        int count = 1;
        for (int num: nums) {
            cur += num;
            if (cur > max) {
                cur = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}