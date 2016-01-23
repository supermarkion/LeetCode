/*
    Given two strings s and t, write a function to determine if t is an anagram of s.
    
    Link: https://leetcode.com/problems/valid-anagram/

    Example: For example,
		s = "anagram", t = "nagaram", return true.
		s = "rat", t = "car", return false.

    Solution: In these problem, I use a map to save the relationship between char and its frequency, then compare this
    map with next string content.

    Source: None
*/

public class Solution {
    public boolean isAnagram(String s, String t) {
        boolean flag = false;
        if (s == null || t == null || s.length() != t.length()) {
            return flag;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) - 1 < 0) {
                    return false;
                }
                map.put(c, map.get(c) - 1);
            }
        }
        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
