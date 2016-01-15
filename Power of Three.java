/*
    Given an integer, write a function to determine if it is a power of three.

    Link: https://leetcode.com/problems/power-of-three/

    Example: None

    Solution: None

    Source: https://leetcode.com/discuss/78532/summary-all-solutions-new-method-included-at-15-30pm-jan-8th
*/

public class Solution {
    public boolean isPowerOfThree(int n) {
        int[] allPowerOfThree = new int[]{1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467};
        return Arrays.binarySearch(allPowerOfThree, n) >= 0;
    }
}