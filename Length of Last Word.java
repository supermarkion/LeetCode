/*
    Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the 
    string. If the last word does not exist, return 0.

    Link: https://leetcode.com/problems/length-of-last-word/

    Example: For example, Given s = "Hello World", return 5.

    Solution: None
    
    Source: None
*/

public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int start = 0, end = s.length() - 1;
        while (start < s.length() && s.charAt(start) == ' ') {
            start++;
        }
        while (end > start && s.charAt(end) == ' ') {
            end--;
        }
        for (int i = start; i < end + 1; i++) {
            if (s.charAt(i) == ' ') {
                result = 0;
            } else {
                result++;
            }
        }
        return result;
    }
}