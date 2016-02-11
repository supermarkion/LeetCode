/*
    Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation 
    is counted as 1 step.) You have the following 3 operations permitted on a word:
		a) Insert a character
		b) Delete a character
		c) Replace a character

    Link: https://leetcode.com/problems/edit-distance/

    Example: None

    Solution: In the problem, it assumes that each string can be change to another change by perform length of string
	operations. Therefore, in the initialize operation of dynamic programming matrix, we increase the values of
	first column and first row. After that, we loop this matrix, when facing a same char between two words, we
	assign this cell with the minimum value of its left-top, left, and top (which means there is no need the add a
	new operation). If they are not same, we also get the minimum vales of its left-top, left and top, but plus 1
	to this cell.
    
    Source: None
*/

public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = 0, len2 = 0;
        if (word1 != null && word2 != null) {
            len1 = word1.length();
            len2 = word2.length();
        }
        if (word1 == null || word2 == null) {
            return Math.max(len1, len2);
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], 1 + dp[i - 1][j]);
                    dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                    dp[i][j] = 1 + Math.min(dp[i][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}