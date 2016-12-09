/*
	Count the number of segments in a string, where a segment is defined to be a contiguous 
	sequence of non-space characters.

	Please note that the string does not contain any non-printable characters.
    
    Link: https://leetcode.com/problems/number-of-segments-in-a-string/

    Example: 

		Input: "Hello, my name is John"
		Output: 5
            
    Solution: None

    Source: None
*/

public class Solution {
    public int countSegments(String s) {
        int result = 0;
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
            	result++;        
            }
        }
        return result;
    }
}