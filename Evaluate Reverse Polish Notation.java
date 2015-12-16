/*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, /. Each operand may be an integer or another expression.
    Link: https://leetcode.com/problems/evaluate-reverse-polish-notation/
    Example: 
      ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
      ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
    
    Solution: None
    Source: None
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();
        for (String token : tokens) {
            if (!operators.contains(token)) {
                stack.push(token);
            } else {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int operate = operators.indexOf(token);
                switch(operate) {
                    case 0:
                        stack.push(String.valueOf(a + b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b - a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a * b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
}