/*
    Write a function to find the longest common prefix string amongst an array of strings.
    Link: https://leetcode.com/problems/longest-common-prefix/
    Example: None
    Solution: In this problem, it is easy to solve by compare the prefix based on chars in first string. 
    When facing the different, we return the current result.
    Source: None
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i) ;
                }
            }
        }
        return strs[0];
    }
}
