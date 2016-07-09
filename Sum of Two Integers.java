/*
    Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.

    Link: https://leetcode.com/problems/sum-of-two-integers/

    Example: 
    	Given a = 1 and b = 2, return 3.
    
    Solution: None

    Source: https://discuss.leetcode.com/topic/50236/java-straightforward-solution
*/

public class Solution {
    public int getSum(int a, int b) {
        int carry  = 0;
        int curBitOfA, curBitOfB, curBit;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            curBitOfA = (a >> i) & 1;
            curBitOfB = (b >> i) & 1;
            curBit = curBitOfA ^ curBitOfB ^ carry;
            res |= (curBit << i);
            if ((curBitOfA & curBitOfB) == 1 || ((curBitOfA | curBitOfB) & carry) == 1) {
            	carry = 1;	
            } else {
            	carry = 0;	
            } 
        }
        return res;
    }
}
