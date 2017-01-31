/*
    For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.

	Now given a string representing n, you should return the smallest good base of n in string format. 

    Link: https://leetcode.com/problems/smallest-good-base/

	Example: 
	
		Example 1:
			Input: "13"
			Output: "3"
			Explanation: 13 base 3 is 111.

		Example 2:
			Input: "4681"
			Output: "8"
			Explanation: 4681 base 8 is 11111.
		
		Example 3:
			Input: "1000000000000000000"
			Output: "999999999999999999"
			Explanation: 1000000000000000000 base 999999999999999999 is 11.

    Solution: None

    Source: https://discuss.leetcode.com/topic/76406/java-c-binary-search-solutions-with-detailed-explanation
*/

import java.math.*;

public class Solution {
    public String smallestGoodBase(String n) {
        BigInteger N = new BigInteger(n);
        long base = Long.MAX_VALUE;

        for (int k = 2; k < 66; k++) {
            long l = 2, r = Long.MAX_VALUE - 5;
            while (l <= r) {
                long mid = l + (r - l) / 2;
                BigInteger cb = BigInteger.valueOf(mid).pow(k).subtract(BigInteger.ONE);
                BigInteger wb = N.multiply(BigInteger.valueOf(mid).subtract(BigInteger.ONE));
                int cmp = cb.compareTo(wb);
                if (cmp == 0) {
                    base = Math.min(base, mid);
                    break;
                } else if (cmp < 0) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return "" + base;
    }
}