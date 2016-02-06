/*
	Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more 
    dictionary words.

    Link: https://leetcode.com/problems/word-break/

    Example: For example, given
        s = "leetcode",
        dict = ["leet", "code"].
    Return true because "leetcode" can be segmented as "leet code".

    Solution: None

    Source: None
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        int max_word_len = 0;
        for (String word : wordDict) {
            max_word_len = Math.max(max_word_len, word.length());
        }
        boolean[] can_break = new boolean[s.length() + 1];
        can_break[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (i - j > max_word_len) {
                    break;      // this substring is to long, not need compare
                }
                String word = s.substring(j, i);
                if (can_break[j] && wordDict.contains(word)) {
                    can_break[i] = true;
                    break;
                }
            }
        }
        return can_break[s.length()];
    }
}