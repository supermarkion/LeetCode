/*
    Given a string S and a string T, count the number of distinct subsequences of T in S. A subsequence of a 
    string is a new string which is formed from the original string by deleting some (can be none) of the 
    characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a 
    subsequence of "ABCDE" while "AEC" is not).
    
    Link: https://leetcode.com/problems/distinct-subsequences/

    Example: Here is an example: S = "rabbbit", T = "rabbit". Return 3.

    Solution: None
    
    Source: None
*/

public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
        	return 0;
        }
        if (s.length() < t.length()) {
        	return 0;
        }
        if (t.length() == 0) {
        	return 1;
        }

        int[] f = new int[t.length() + 1];
        f[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = t.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == t.charAt(j)) {
                        f[j + 1] += f[j];
                }
            }
        }

        return f[t.length()];
    }
}