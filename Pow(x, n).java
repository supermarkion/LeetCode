/*
    Implement pow(x, n).
    
    Link: https://leetcode.com/problems/powx-n/

    Example: None

    Solution: The main point is that n is greater than 0 or less.
    
    Source: https://leetcode.com/discuss/72398/java-log-n-solution
*/

public class Solution {
    public double myPow(double x, int n) {
        if (x == 0) { 
            return 0;
        }
        if (n == 0) {
            return 1;
        }
    
        int nSign = n < 0 ? -1 : 1;
        n = Math.abs(n);
    
        double result = myPow(x, n / 2); // use recursion to speed up
        result *= result;
        if (n % 2 != 0) {
            result *= x;
        }
    
        return nSign < 0 ? 1 / result : result;
    }
}