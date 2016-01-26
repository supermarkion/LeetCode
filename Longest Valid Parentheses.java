/*
    Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
    
    Link: https://leetcode.com/problems/longest-valid-parentheses/

    Example: 
    	For "(()", the longest valid parentheses substring is "()", which has length = 2.
		Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.


    Solution: None
    
    Source: https://leetcode.com/discuss/79112/java-easy-version-to-understand
*/

public class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length(), maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
    
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else {
                if (stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                    maxLen = Integer.max(i - stack.peek(), maxLen);
                } else 
                    stack.push(i);
            }
        }
        return maxLen;
    }
}