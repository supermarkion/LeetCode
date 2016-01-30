/*
    Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

    Link: https://leetcode.com/problems/perfect-squares/

    Example: For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

    Solution: None
    
    Source: https://leetcode.com/discuss/81013/58ms-java-dp-solution-beating-over-90%25
*/

public class Solution {
    /**
     * s[i] denotes the least number of square numbers that add up to n
     * initial s[i] as maximum integer
     * for i from 1 to n, 
     *      if i is perfect square, s[i]=1, 
     *      otherwise get the square root of the maximum perfect square smaller than i
     * for j from 1 to square root, 
     *      if(s[i-j*j]+1 smaller than s[i]) update s[i] as s[i-j*j]+1
     * 
     **/
    public int numSquares(int n) {
        int[] s = new int[n + 1];
        for (int i = 0;i < n + 1 ; i++) s[i] = Integer.MAX_VALUE;
        //note to me: no need to store a list of perfect squares, knowing the square root of the largest perfect square is sufficient
        //List<Integer> squares = new ArrayList<Integer>();
        for (int i = 1;i < n + 1; i++) {
            int sqrt = (int)Math.sqrt(i);
            if (i == sqrt * sqrt) {
                s[i] = 1;
                continue;
            }
            for (int j = 1; j <= sqrt; j++) {
                if (s[i-j*j] + 1 < s[i]) {
                    s[i] = s[i - j * j] + 1;
                }
            }
        }
        return s[n];
    }
}