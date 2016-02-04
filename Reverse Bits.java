/*
    Reverse bits of a given 32 bits unsigned integer.

    Link: https://leetcode.com/problems/reverse-bits/

    Example: For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
    return 964176192 (represented in binary as 00111001011110000010100101000000).

    Solution: None
    
    Source: https://leetcode.com/discuss/77219/2ms-java-solution
*/

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int answer = 0;
        for (int i = 0; i < 32; i++) { // 32 bit integers
            answer <<= 1; // shifts answer over 1 to open a space
            answer |= ((n >> i) & 1); // inserts bits from n
        }
        return answer;
    }
}