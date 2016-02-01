/*
    Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

    Link: https://leetcode.com/problems/remove-invalid-parentheses/

    Example: Examples:
		"()())()" -> ["()()()", "(())()"]
		"(a)())()" -> ["(a)()()", "(a())()"]
		")(" -> [""]

    Solution: None
    
    Source: https://leetcode.com/discuss/72208/easiest-9ms-java-solution
*/

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        int rmL = 0, rmR = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
            	rmL++;
            }
            if (s.charAt(i) == ')') {
                if (rmL != 0) {
                	rmL++;
                } else {
                	rmR++;
                }
            }
        }
        DFS(res, s, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<String>(res);  
    }
    
    public void DFS(Set<String> res, String s, int i, int rmL, int rmR, int open, StringBuilder sb) {
        if (i == s.length() && rmL == 0 && rmR == 0 && open == 0) {
            res.add(sb.toString());
            return;
        }
        if (i == s.length() || rmL < 0 || rmR < 0 || open < 0) {
        	return;
        }
    
        char c = s.charAt(i);
        int len = sb.length();
    
        if (c == '(') {
            DFS(res, s, i + 1, rmL - 1, rmR, open, sb);
            DFS(res, s, i + 1, rmL, rmR, open + 1, sb.append(c)); 
    
        } else if (c == ')') {
            DFS(res, s, i + 1, rmL, rmR - 1, open, sb);
            DFS(res, s, i + 1, rmL, rmR, open - 1, sb.append(c));
    
        } else {
            DFS(res, s, i + 1, rmL, rmR, open, sb.append(c)); 
        }
    
        sb.setLength(len);
    }
}