/*
    Given a string, find the length of the longest substring without repeating characters. 

    Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

    Example: For example, the longest substring without repeating letters for "abcabcbb" 
    is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the 
    length of 1.

    Solution: None
    
    Source: None
*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 2) {
            return s.length();
        }
        // use a map to save relationship between char and its first locations
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        int lastMax = 0, max = 0, index = 0, start = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (charMap.get(c) == null || charMap.get(c) < start) {
                max++;
                charMap.put(c, index);
            } else {
                if (max > lastMax) {
                    lastMax = max;                    
                }
                max = index - charMap.get(c); // get distance
                start = charMap.get(c) + 1;
                charMap.put(c, index);
            }
            index++;
        }
        return lastMax > max ? lastMax : max;
    }
}