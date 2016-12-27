/*
    The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

	Given two integers x and y, calculate the Hamming distance.

	Note:
		0 ≤ x, y < 2^{31}.
    
    Link: https://leetcode.com/problems/hamming-distance/

    Example: 
    	
    	Input: x = 1, y = 4
		Output: 2
		Explanation:
			1   (0 0 0 1)
			4   (0 1 0 0)
       			   ↑   ↑

	The above arrows point to positions where the corresponding bits are different.

    Solution: None

    Source: https://discuss.leetcode.com/topic/72089/java-3-line-solution
*/

public class Solution {
	public int hammingDistance(int x, int y) {
	    int xor = x ^ y, count = 0;
	    for (int i = 0; i < 32; i++) {
	    	count += (xor >> i) & 1;
	    }
	    return count;
	}    
}