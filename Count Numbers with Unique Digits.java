/*
    Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.

    Link: https://leetcode.com/problems/count-numbers-with-unique-digits/

    Example: 
    	Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, 
    	excluding [11,22,33,44,55,66,77,88,99])
    
    Solution: None

    Source: https://leetcode.com/discuss/108153/easy-java-solution
*/

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
        	return 1;	
        }

        int result = 1;
        int availableDigits = 9;
        int temp = 1;
    
        for (int i = 0; i < n; i++) {
            if (i > 1) {
            	availableDigits -= 1;	
            } 
            temp *= availableDigits;
            result += temp;
        }
        return result;
    }
}