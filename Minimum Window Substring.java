/*
    Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
    
    Link: https://leetcode.com/problems/minimum-window-substring/

    Example: For example,
		S = "ADOBECODEBANC"
		T = "ABC"
		Minimum window is "BANC".

    Solution: 
	    1.Use a hash array to store character appear times in string t.
		2.Use two pointers to try all the possible window which includes t.
		3.In the beginning, start and end pointer points to the start of string s,
		and then move end until including all the characters in t, check whether
		can move start pointer. If so, move start pointer. 
		4.Continue the process until end pointer reaches the end of string s.
		time complexity: O(n)
    
    Source: https://leetcode.com/discuss/82006/30-lines-java-o-n-solution-with-one-array
*/

public class Solution {
    public String minWindow(String s, String t) {
        int[] t_c = new int[128];
        int count = t.length();
        if(s.length() < count) {
        	return "";
        }
        for(int i = 0; i< count; i++) {
        	t_c[t.charAt(i)]++;
        }   
        int start = 0, end = 0;
        String res = "";
        boolean isStart = false;//whether move start pointer or not
        while ( end < s.length()) {
          if (!isStart) {
            if (t_c[s.charAt(end)] > 0) {
            	count--;
            }
            t_c[s.charAt(end)]--;       
          }              
          if (count == 0) {
              if (res == "" || end - start + 1 < res.length()) {
              	res = s.substring(start, end + 1);
              }
              if (res.length() == t.length()) {
              	return res;
              }
          }           
          if (t_c[s.charAt(start)] < 0 && count == 0) {           
                t_c[s.charAt(start)]++;
                if (t_c[s.charAt(start)] > 0) {
                	count++;
                }
                start++;
                isStart = true;
          } else {
            isStart = false;
            end++;
          }
        }
        return res;
    }
}