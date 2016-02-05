/*
    Given a column title as appear in an Excel sheet, return its corresponding column number.

    Link: https://leetcode.com/problems/excel-sheet-column-number/

    Example: 
    	A -> 1
	    B -> 2
	    C -> 3
	    ...
	    Z -> 26
	    AA -> 27
	    AB -> 28 

    Solution: None
    
    Source: None
*/

public class Solution {
    public int titleToNumber(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int digital = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i) - 'A' + 1) * digital;
            digital *= 26;
        }
        return result;
    }
}