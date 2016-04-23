/*
    Write a function that takes a string as input and returns the string reversed. 

    Link: https://leetcode.com/problems/reverse-string/

    Example: 
	    Given s = "hello", return "olleh".
	
    Solution: None

    Source: None
*/

public class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder("");
        for (int i = s.length() - 1; i >= 0 ; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}