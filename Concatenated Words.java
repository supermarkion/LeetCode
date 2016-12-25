/*
    Given a list of words (without duplicates), please write a program that returns all concatenated words in the given list of words.

	A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

		1. The number of elements of the given array will not exceed 10,000
		2. The length sum of elements in the given array will not exceed 600,000.
		3. All the input string will only include lower case letters.
		4. The returned elements order does not matter.
    
    Link: https://leetcode.com/problems/concatenated-words/

    Example: 
    	
    	Input: 
    		["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
		Output: 
			["catsdogcats","dogcatsdog","ratcatdogcat"]
		Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats"; 
 			"dogcatsdog" can be concatenated by "dog", "cats" and "dog"; 
			"ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".

    Solution: None

    Source: https://discuss.leetcode.com/topic/72113/java-dp-solution/2
*/

public class Solution {
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare (String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        for (int i = 0; i < words.length; i++) {
            if (canForm(words[i], preWords)) {
                result.add(words[i]);
            }
            preWords.add(words[i]);
        }
        
        return result;
    }
	
    private static boolean canForm(String word, Set<String> dict) {
        if (dict.isEmpty()) return false;
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= word.length(); i++) {
		    for (int j = 0; j < i; j++) {
				if (!dp[j]) {
					continue;
				}
				if (dict.contains(word.substring(j, i))) {
			    dp[i] = true;
			    break;
				}
	    	}
		}
		return dp[word.length()];
    }
}