/*
    Validate if a given string is numeric.

    Link: https://leetcode.com/problems/valid-number/

    Example: Some examples:
		"0" => true
		" 0.1 " => true
		"abc" => false
		"1 a" => false
		"2e10" => true

    Solution: When we meet a string, when should skip the empty spaces between and after string. Then, we skip the
	signal of string (if it has). Then, once we meet a character is digit, we set number flag is true. Once we meet
	a dot, we set dot flag is true. Once we meet a e, if current is not a number or not a exp, it return false, or
	we set exp flag is true, and number flag is false. If we meet a plus or minus operation, if the character before
	it not the e, it also false.
    
    Source: https://leetcode.com/discuss/81178/a-no-cheating-5ms-java-solution-easy-to-understand
*/

public class Solution {
    public boolean isNumber(String s) {
        // very very boring
        int i = 0;
        int n = s.length();
    
        //find the first non-space character
        while (i < n && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
    
        //check if optional '+' or '-' sign exists
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            i++;
        }
    
        boolean isBaseNumeric = false;
        boolean isExpNumeric = true;
        //loop over the remaining string, special cases to consider "0.1", "1.", ".1", "2e-2", "2E-2", ".e1", ".8+"
        while (i < n && Character.isDigit(s.charAt(i))) {
            isBaseNumeric = true;
            i++;
        }
    
        //check '.'
        if (i < n && s.charAt(i) == '.') {
            i++;
            while (i < n && Character.isDigit(s.charAt(i))) {
                isBaseNumeric = true;
                i++;
            }
        }
    
        //check 'e'
        if (isBaseNumeric && i < n && (s.charAt(i) == 'e' || s.charAt(i) == 'E')) {
            isExpNumeric = false;
            i++;
            if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                i++;
            }
            while (i < n && Character.isDigit(s.charAt(i))) {
                isExpNumeric = true;
                i++;
            }
        }
    
        //check if remaining characters are all spaces 
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
    
        return isBaseNumeric && isExpNumeric && (i == n);
    }
}