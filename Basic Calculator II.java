/*
	Implement a basic calculator to evaluate a simple expression string. The expression string contains 
	only non-negative integers, +, -, *, / operators and empty spaces . The integer division should 
	truncate toward zero. You may assume that the given expression is always valid.
    
    Link: https://leetcode.com/problems/basic-calculator-ii/

    Example: Some examples:
		"3+2*2" = 7
		" 3/2 " = 1
		" 3+5 / 2 " = 5

    Solution: None
    
    Source: https://leetcode.com/discuss/83062/java-11ms-concise-and-fast-solution-with-comments-beats-02%25
*/

public class Solution {
    public int calculate(String s) {
        int val = 0;
        int num = 0; //individual number in the string
        int oper = 1; //1: +  -1: -
        int tmp = 1; //temp value for binary expressions that only have an operator of '*' or '/'
        int tmpOper = 0; //temp operator for binary expressions  0: *  1: /
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '+': 
                	val = val + calc(tmp, tmpOper, num) * oper; num = 0; tmp = 1; tmpOper = 0; oper = 1; 
                	break; //end of number 
                case '-': 
                	val = val + calc(tmp, tmpOper, num) * oper; num = 0; tmp = 1; tmpOper = 0; oper = -1; 
                	break; //end of number 
                case '*': 
                	tmp = calc(tmp, tmpOper, num); num = 0; tmpOper = 0; 
                	break;// end of number and keep calculating binary expression
                case '/': 
                	tmp = calc(tmp, tmpOper, num); num = 0; tmpOper = 1; 
                	break;// end of number and keep calculating binary expression
                case ' ': 
                	continue;
                default: 
                	num = num * 10 + c - '0';
            }
        }
        return val + calc(tmp, tmpOper, num) * oper; //deal with the last num
    }
    private int calc(int tmp, int tmpOper, int num){
        switch(tmpOper){
            case 0: 
            	return tmp * num;
            case 1: 
            	return tmp / num;
            default: 
            return 0;
        }
    }
}