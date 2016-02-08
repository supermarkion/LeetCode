/*
    Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
		Return all such possible sentences.

    Link: https://leetcode.com/problems/word-break-ii/

    Example: For example, given
		s = "catsanddog",
		dict = ["cat", "cats", "and", "sand", "dog"].
		A solution is ["cats and dog", "cat sand dog"].

    Solution: None
    
    Source: https://leetcode.com/discuss/70857/16ms-java-dp-dfs-solution
*/

public class Solution {
    List<String> result;
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        
        result = new ArrayList<String>();
        int n = s.length();
        List<Integer>[] pointer = new List[n];
        for (int i = 0; i < n; i++) {
        	pointer[i] = new ArrayList<Integer>();
        }
        // DP to record break point
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++){
            	// save all possible words by divied a string in each pointer
                if (wordDict.contains(s.substring(j, i + 1)) && (j == 0 || pointer[j - 1].size() > 0)) {
                	pointer[i].add(j);
                }
            }
        }
        helper(pointer, s, n - 1, "");
        return result;
    }
    // DFS to retrieve results
    public void helper(List<Integer>[] pointer, String s, int i, String pattern){
        if (i < 0) {
            result.add(pattern);
            return;
        }
        for (Integer item : pointer[i]) {
            String nextPattern = pattern.length() == 0 ? s.substring(item, i + 1) : s.substring(item, i + 1) + " " + pattern;
            helper(pointer, s, item - 1, nextPattern);
        }
    }
}