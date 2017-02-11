/*
	Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

    Link: https://leetcode.com/problems/longest-palindromic-subsequence/

	Example: 
	
		Example 1:
			Input:
			"bbbab"
			Output:
			4
			One possible longest palindromic subsequence is "bbbb".
		
		Example 2:
			Input:
			"cbbd"
			Output:
			2
			One possible longest palindromic subsequence is "bb".
		
    Solution: None

    Source: https://discuss.leetcode.com/topic/78732/java-ac-o-n-2-dp-solution
*/

public class Solution {
    public int longestPalindromeSubseq(String s) {
    	int n = s.length();
    	int[][] M = new int[n][n];
    	int max = 0;
    	for (int i = n - 1; i >= 0; i--) {
    		for (int j = i; j <= n - 1; j++) {
    			if (i == j) {
    				M[i][j] = 1;
    			} else if (s.charAt(i) == s.charAt(j)) {
    				// fine even if i + 1 > j - 1, because cells in the
    				// bottom-left triangle are all zero
    				M[i][j] = M[i + 1][j - 1] + 2;
    			} else if (s.charAt(i) != s.charAt(j)) {
    				M[i][j] = Math.max(M[i + 1][j], M[i][j - 1]);
    			}
    			max = Math.max(max, M[i][j]);
    		}
    	}
    	return max;
    }
}