/*
    Given two strings s and t, determine if they are isomorphic. Two strings are isomorphic if 
    the characters in s can be replaced to get t. All occurrences of a character must be replaced 
    with another character while preserving the order of characters. No two characters may map to 
    the same character but a character may map to itself.

    Link: https://leetcode.com/problems/isomorphic-strings/

    Example: For example,
		Given "egg", "add", return true.
		Given "foo", "bar", return false.
		Given "paper", "title", return true.

    Solution: None
    
    Source: https://leetcode.com/discuss/83190/java-solution-beats-84%25-12-lines-in-total
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
        	return false;
        }
        if (s.length() == 0) {
        	return true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
        	// when not match one to one, fail
            if (s.indexOf(s.charAt(i), i + 1) != t.indexOf(t.charAt(i), i + 1)) {
                return false;
            }
        }
        return true;
    }
}