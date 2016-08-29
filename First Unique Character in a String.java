/*
    Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

    Link: https://leetcode.com/problems/first-unique-character-in-a-string/

    Example: 
    	s = "leetcode"
		return 0.

		s = "loveleetcode",
		return 2.

    Solution: None

    Source: https://discuss.leetcode.com/topic/56055/simpe-java-solution
*/

public class Solution {
	
    public int firstUniqChar(String s) {
        int[] cache = new int[26];
        for (char c : s.toCharArray()) {
        	cache[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (cache[s.charAt(i) - 'a'] == 1) {
            	return i;
            }
        }
        return -1;
    }
}