/*
	Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    Link: https://leetcode.com/problems/valid-palindrome/https://leetcode.com/problems/valid-palindrome/

    Example: For example,
		"A man, a plan, a canal: Panama" is a palindrome.
		"race a car" is not a palindrome.

    Solution: The simple solution is based on the filter action on whether this char is a alpha or a number based on its
    char value is between ’a’ and ’z’, and ’0’ and ’9’.

    Source: None
*/

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}