/*
    You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
    Given n, find the total number of full staircase rows that can be formed.
    n is a non-negative integer and fits within the range of a 32-bit signed integer.

    Link: https://leetcode.com/problems/arranging-coins/

    Example: 
        Example 1:
        n = 5
        The coins can form the following rows:

        ¤
        ¤ ¤
        ¤ ¤

        Because the 3rd row is incomplete, we return 2.

        Example 2:
        n = 8
        The coins can form the following rows:

        ¤
        ¤ ¤
        ¤ ¤ ¤
        ¤ ¤

        Because the 4th row is incomplete, we return 3.

    Solution: None

    Source: https://discuss.leetcode.com/topic/65879/easy-to-understand-o-1-java
*/

public class Solution {
    public int arrangeCoins(int n) {
        int x =(int) Math.sqrt((long)2 * n);
        return x * (x + 1) <= 2 * n ? x : x - 1;
    }
}