/*
    Given an unsorted array of integers, find the length of longest increasing subsequence.
    Link: https://leetcode.com/problems/longest-increasing-subsequence/
    Example: Given [10, 9, 2, 5, 3, 7, 101, 18],
    The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that
    there may be more than one LIS combination, it is only necessary for you to return the length.
    Solution: Given a sequence of integers, find the longest increasing subsequence (LIS). In order to solve this problem
    by dynamic programming method, we should know that the dp list save the information that the number
    in the current index have the LIS value. In order to finish that, we should compare current number and its
    previous numbers. In order to speed up this process, we use a dp list to save the previous LIS values.
    Source: http://yucoding.blogspot.com.au/2015/07/leetcode-question-add-and-search-word.html
*/

public class Solution {
    public int lengthOfLIS(int [] nums) {
    // write your code here
    if ( nums == null || nums.length == 0) {
        return 0;
    }
    int[] f = new int[nums.length];
    int max = 0;
    for ( int i = 0; i < nums.length; i ++) {
        f[i] = 1;
        for (int j = 0; j < i ; j ++) {
            if (nums [j] < nums [i]) { // if equal is also OK, we add '='
                f[i] = Math.max(f[i], f[j] + 1);
            }
        }
        if (f[i] > max) {
            max = f [i];
        }
    }
    return max ;
    }
}