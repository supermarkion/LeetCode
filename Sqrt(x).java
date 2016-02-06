/*
	Implement int sqrt(int x). Compute and return the square root of x.

    Link: https://leetcode.com/problems/sqrtx/

    Example: For example,
		"A man, a plan, a canal: Panama" is a palindrome.
		"race a car" is not a palindrome.

    Solution: Apply Newtonś Method

    Source: None
*/

public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double last = 0;
        double res = 1;
        while (res != last) {
            last = res;
            res = (res + x / res) / 2;
        }
        return (int)res;
    }
}