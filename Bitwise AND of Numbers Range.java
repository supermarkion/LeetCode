/*
    Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

    Link: https://leetcode.com/problems/bitwise-and-of-numbers-range/

    Example: given the range [5, 7], you should return 4.

    Solution: None
    
    Source: None
*/

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        
        while (m != n) {
            n >>= 1;
            m >>= 1;
            i++;
        }
        
        return m << i;
    }
}