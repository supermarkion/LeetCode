/*
    Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every 
    character in T appears no less than k times.

    Link: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

    Example: 

		Example 1:

			Input:
			s = "aaabb", k = 3

			Output:
			3

			The longest substring is "aaa", as 'a' is repeated 3 times.

		Example 2:

			Input:
			s = "ababbc", k = 2

			Output:
			5

			The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.

    Source: https://discuss.leetcode.com/topic/57077/java-solution-using-2d-array-to-store-letter-occurrences-17ms-o-n
*/

public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() < 1) {
        	return 0;
        }

        int[][] letters = new int[26][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int c = 0; c < 26; c++) {
                letters[c][i + 1] = letters[c][i];
            }
            letters[s.charAt(i) - 'a'][i + 1] += 1;
        }
        // May also optimize by deleting letters entries with 0 at end
        
        int longest = 0;
        for (int start = 0; start < s.length(); start++) {
            if (longest >= s.length() - start) {
            	return longest;
            }
            for (int end = s.length(); end > start; end--) {
                boolean works = true;
                for (int c = 0; c < 26; c++) {
                    int num = letters[c][end] - letters[c][start];
                    if (num < k && num > 0) {
                        works = false;
                        end = s.indexOf('a' + c, start) + 1;
                        break;
                    }
                }
                if (works) {
                    if (end - start > longest) {
                    	longest = end - start;
                    }
                    break;
                }
            }
        }

        return longest;
    }
}
