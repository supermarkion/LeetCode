/*
    Count the number of prime numbers less than a non-negative number, n.

    Link: https://leetcode.com/problems/count-primes/

    Example: None

    Solution: None
    
    Source: https://leetcode.com/discuss/81779/12-ms-java-solution-modified-from-the-hint-method-beats-99-95%25
*/

public class Solution {
    public int countPrimes(int n) {
        if (n < 3) {
        	return 0;
        }
            
        boolean[] f = new boolean[n];
        //Arrays.fill(f, true); boolean[] are initialed as false by default
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i]) {
            	continue;
            }

            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    --count;
                    f[j] = true;
                }
            }
        }
        return count;
    }
}