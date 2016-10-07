/*
    Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
    This is case sensitive, for example "Aa" is not considered a palindrome here.
    
    Note:
        Assume the length of given string will not exceed 1,010.

    Link: https://leetcode.com/problems/longest-palindrome/

    Example: 
        Input:
        "abccccdd"

        Output:
        7

        Explanation:
        One longest palindrome that can be built is "dccaccd", whose length is 7.

    Solution: None

    Source: https://discuss.leetcode.com/topic/61821/my-java-solution
*/

 import java.util.*;
 import java.util.Map.Entry;
 
 public class Solution {
    public int longestPalindrome(String s) {
        int sum = 0;
        Hashtable<Character,Integer> table = new Hashtable();
        for (int i = 0; i < s.length(); i++) {
            Integer count = table.get(s.charAt(i));
            if (count != null) {
                table.put(s.charAt(i), ++count);
            } else {
                table.put(s.charAt(i), 1);
            }
                
        }
        if (table.size() == 1) {
            return s.length();
        }
            
        Set<Entry<Character, Integer>> entrySet = table.entrySet();
        boolean v = true;
        for (Entry<Character,Integer> entry : entrySet) {   
            int tmp = 0;
            tmp = entry.getValue();
            if (tmp % 2 == 0) {
                sum += tmp;
            } else if(tmp >2) {
                if (v == true) {
                    sum += tmp;
                    v = false;
                } else {
                    sum += tmp - 1;
                }
            } else if ((tmp == 1) &&(v == true)) {
                sum++;
                v = false;
            }
        }
        return sum;
    }
}