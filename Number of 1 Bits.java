/*
    Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

    Link: https://leetcode.com/problems/number-of-1-bits/

    Example: 
        For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should 
        return 3.

    Solution: s is number of set bits in n. n & ~(n - 1) reserves the lowest set bit of n. xor with itself removes that set bit.
    
    Source: https://leetcode.com/discuss/83766/java-o-s-solution-with-tricks
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int y;
        while (n != 0) {
            count++;
            n ^= n & ~(n - 1);
        }
        return count;
    }
}