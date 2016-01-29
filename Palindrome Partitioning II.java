/*
    Given a string s, partition s such that every substring of the partition is a palindrome.
    Return the minimum cuts needed for a palindrome partitioning of s.
    
    Link: https://leetcode.com/problems/palindrome-partitioning-ii/

    Example: For example, given s = "aab",
        Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

    Solution: None
    
    Source: https://leetcode.com/problems/palindrome-partitioning-ii/
*/

public class Solution {
    public int minCut(String s) {
        int n = s.length();
 
        boolean dp[][] = new boolean[n][n];
        int cut[] = new int[n];
     
        for (int j = 0; j < n; j++) {
            cut[j] = j; //set maximum # of cut
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
     
                    // if need to cut, add 1 to the previous cut[i-1]
                    if (i > 0){
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    }else{
                    // if [0...j] is palindrome, no need to cut    
                        cut[j] = 0; 
                    }   
                }
            }
        }
     
        return cut[n - 1];
    }
}