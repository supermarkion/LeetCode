/*
    The count-and-say sequence is the sequence of integers beginning as follows: 1, 11, 21, 1211, 111221, ...
    Given an integer n, generate the nth sequence.

    Link: https://leetcode.com/problems/count-and-say/

    Example: 
        1 is read off as "one 1" or 11.
        11 is read off as "two 1s" or 21.
        21 is read off as "one 2, then one 1" or 1211.

    Solution: None
    
    Source: None
*/

public class Solution {
    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }
        String s = "1";
        for (int i = 1; i < n; i++) {
            int count = 1;
            StringBuilder sb = new StringBuilder();
            int sLen = s.length();
            for (int j = 0; j < sLen; j++) {
                if (j < sLen - 1 && s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                } else {
                    sb.append(count + "" + s.charAt(j));
                    count = 1;
                }
            }
            s = sb.toString();
        }
        return s;
    }
}