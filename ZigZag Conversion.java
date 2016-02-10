/*
   	The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
   	(you may want to display this pattern in a fixed font for better legibility)
		P   A   H   N
		A P L S I I G
		Y   I   R
	And then read line by line: "PAHNAPLSIIGYIR"

    Link: https://leetcode.com/problems/zigzag-conversion/
    
    Example: Write the code that will take a string and make this conversion given a number of rows:
		string convert(string text, int nRows);
		convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

    Solution: None
    
    Source: https://leetcode.com/discuss/79206/the-8ms-java-solution-in-o-n-time-use-iteration
*/

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) {
        	return s;
        }
            
        int g = (2 * numRows - 2);
        StringBuilder sb = new StringBuilder(s.length());
        for (int k = 0; k < numRows; k++) {
            for (int i = k; i < s.length(); ){
                sb.append(s.charAt(i));
                if (k == 0 || k == numRows - 1) {
                	i += g;
                } else if(i % g > numRows - 1) {
                	i += 2 * k;
                } else {
                	i += (g - 2 * k);
                }
                    
            }
        }
        return sb.toString();
    }
}