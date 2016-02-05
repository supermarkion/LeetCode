/*
    Given a positive integer, return its corresponding column title as appear in an Excel sheet.

    Link: https://leetcode.com/problems/excel-sheet-column-title/

    Example: 
    	1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB 

    Solution: None
    
    Source: None
*/

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0) {
            char ch = (char)((n - 1) % 26 + 65);
            n = (n - 1) / 26;
            sb.append(ch);
        }
        return sb.reverse().toString();
    }
}