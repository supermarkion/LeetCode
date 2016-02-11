/*
    GImplement strStr(). Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack

    Link: https://leetcode.com/problems/implement-strstr/

    Example: None

    Solution: None
    
    Source: None
*/

public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }

        int i, j;
        for (i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                } 
            } 
            if (j == needle.length()) {
                return i;
            }
        }

        // did not find the needle
        return -1;
    }
}