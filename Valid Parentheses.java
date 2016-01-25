/*
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    Link: https://leetcode.com/problems/valid-parentheses/

    Example: None

    Solution: The simple solution is based on the filter action on whether this char is a alpha or a number based on its
	char value is between ’a’ and ’z’, and ’0’ and ’9’.
    
    Source: None
*/

public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] c_arr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (Character c : c_arr) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && stack.peek() == '{') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? true : false;
    }
}