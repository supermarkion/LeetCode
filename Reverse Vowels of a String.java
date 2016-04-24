/*
    Write a function that takes a string as input and reverse only the vowels of a string.

    Link: https://leetcode.com/problems/reverse-vowels-of-a-string/

    Example: 
    	Example 1:
		Given s = "hello", return "holle".

		Example 2:
		Given s = "leetcode", return "leotcede".

    Solution: None

    Source: None
*/

public class Solution {
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] sChars = s.toCharArray();
        while (start < end) {
            while (start < s.length() - 1 && !isVowel(sChars[start])) {
                start++;
            }
            while (end >= 0 && !isVowel(sChars[end])) {
                end--;
            }
            if (start >= end) {
                break;
            }
            char temp = sChars[start];
            sChars[start] = sChars[end];
            sChars[end] = temp;
            start++;
            end--;
        }
        
        return new String(sChars);
    }
    
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c =='i' || c =='o' || c =='u';
    }
}