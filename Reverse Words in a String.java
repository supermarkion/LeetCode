/*
    Given an input string, reverse the string word by word.

    Link: https://leetcode.com/problems/reverse-words-in-a-string/

    Example: For example,
		Given s = "the sky is blue",
		return "blue is sky the".

    Solution: Reverse two times.
    
    Source: None
*/

public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        for (int i = 0, j = strs.length - 1; i < j; i++, j--) {
            String temp = new String(strs[j]);
            strs[j] = new String(strs[i]);
            strs[i] = temp;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strs.length; i++){
            if (strs[i].length() > 0) {
                sb.append(strs[i]);
                if (i < strs.length - 1) {
                    sb.append(" ");
                }
            }
        }
        return sb.toString().trim();
    }
}