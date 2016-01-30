/*
    Write a program to check whether a given number is an ugly number.

    Link: https://leetcode.com/problems/ugly-number/

    Example: For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7. 
    Note that 1 is typically treated as an ugly number.

    Solution: None
    
    Source: None
*/

public class Solution {
    public boolean isUgly(int num) {
        if (num <= 0) {
            return false;
        }

        int[] divisors = {2, 3, 5};

        for(int d : divisors) {
            while (num % d == 0) {
                num /= d;
            }
        }
        return num == 1;
    }
}