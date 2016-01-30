/*
    Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
    
    Link: https://leetcode.com/problems/number-of-digit-one/

    Example: For example: Given n = 13, Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

    Solution: None
    
    Source: https://leetcode.com/discuss/83324/yet-another-java-0-ms-recursive-solution
*/

public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int high = n / 10;
        int one = countOne(high);
        int d0 = n % 10;
        int count = (d0 + 1) * one;
        if (d0 >= 1) {
            ++count;
        }
        --high;
        return count + countDigitOne(high) * 10 + high + 1;
    }
    
    private static int countOne(int n) {
        int count = 0;
        for (int i = n; i > 0; i /= 10) {
            if ((i % 10) == 1) {
                ++count;
            }
        }
        return count;
    }
}