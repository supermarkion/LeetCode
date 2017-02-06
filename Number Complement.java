/*
	Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

    Link: https://leetcode.com/problems/number-complement/

	Example: 
	
		Example 1:
			Input: 5
			Output: 2
			Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
		
		Example 2:
			Input: 1
			Output: 0
			Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
		
    Solution: None

    Source: https://discuss.leetcode.com/topic/77688/java-straightforward-solution
*/

public class Solution {
    public int findComplement(int num) { 
        int tmp = num;
        int n = 1;
        while (tmp != 0) {
            tmp >>= 1;
            n <<= 1;
        }
        return n-num-1;
    }
}