/*
    Given a positive integer num, write a function which returns True if num is a perfect square else False.

    Link: https://leetcode.com/problems/valid-perfect-square/

    Example:
        Input: 16
        Returns: True

        Input: 14
        Returns: False

    Solution: None

    Source: https://leetcode.com/discuss/112172/my-java-binary-search-0ms-solution
*/

public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num == 0) {
            return true;
        }
        long start = 0;
        long end = num;
        while (end > start) {
            long mid = start + (end - start) / 2;
            if ((start == mid && end == start + 1) || (end == mid && start == end - 1)) {
                if (start * start == num) {
                    return true;
                } else if (end * end == num) {
                    return true;
                } else {
                    break;
                }
            }
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return false;
    }
}