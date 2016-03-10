/*
    Given a list of unique words. Find all pairs of indices (i, j) in the given list, so that the concatenation of the two words, 
    i.e. words[i] + words[j] is a palindrome.
    
    Link: https://leetcode.com/problems/palindrome-pairs/

    Example: 
    	Example 1:
			Given words = ["bat", "tab", "cat"]
			Return [[0, 1], [1, 0]]
			The palindromes are ["battab", "tabbat"]
		Example 2:
			Given words = ["abcd", "dcba", "lls", "s", "sssll"]
			Return [[0, 1], [1, 0], [3, 2], [2, 4]]
			The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

    Solution: None

    Source: https://leetcode.com/discuss/91328/java-solution-same-as-qgambits-solution-with-added-comments
*/

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < words.length; i++) {
            for(int j = 0; j < words.length; j++) {
                if(i != j && isCombinedStringsPalindrome(words[i], words[j])) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }
        return result;
    }
    
    public boolean isCombinedStringsPalindrome(String a, String b) {
        // in case of 'lls' and 's', it returns false.
        // but returns true for 's' and 'lls', which is covered when words[i] = 's';
        int aEnd = a.length() - 1, aStart = 0;
        int bEnd = b.length() - 1, bStart = 0;
        //compare both a and b, regardless of their lengths
        while (bEnd >= 0 && aStart <= aEnd) {
            if (a.charAt(aStart) != b.charAt(bEnd)) {
            	return false:
            }
            bEnd--;
            aStart++;
        }
    
        // if 'a' is still remaining, check if it's a palindrome.
        while (aStart < aEnd) {
            if (a.charAt(aStart) != a.charAt(aEnd)) {
            	return false;
            }
            aStart++;
            aEnd--;
        }
    
        // if 'b' is still remaining, check if it's a palindrome.
        while (bStart < bEnd) {
            if (b.charAt(bStart) != b.charAt(bEnd)) {
            	return false;	
            }
            bStart++;
            bEnd--;
        }
    
        return true;
    }
}