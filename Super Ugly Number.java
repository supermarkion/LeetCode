/*
    Write a program to find the nth super ugly number. Super ugly numbers are positive numbers whose all prime factors 
    are in the given prime list primes of size k
    
    Link: https://leetcode.com/problems/super-ugly-number/

    Example: For example,
        [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

    Solution: None
    
    Source: https://leetcode.com/discuss/77231/java-easy-version-to-understand
*/

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0 || primes == null || primes.length == 0)
            return 0;
        int len = primes.length;
        int[] index = new int[len];
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            int lastUglyNumber = result[i - 1];
            for (int j = 0; j < len; j++) {
                while (result[index[j]] * primes[j] <= lastUglyNumber)
                    index[j]++;
            }
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < len; j++) {
                if (result[index[j]] * primes[j] < min)
                    min = result[index[j]] * primes[j];
            }
            result[i] = min;
        }
        return result[n - 1];
    }
}