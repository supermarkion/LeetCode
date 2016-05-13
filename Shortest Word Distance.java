/*
    Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

    Link: https://leetcode.com

    Example: 
    	Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
		Given word1 = “coding”, word2 = “practice”, return 3.
		Given word1 = "makes", word2 = "coding", return 1.

    Solution: None

    Source: http://blog.csdn.net/xudli/article/details/48766955
*/

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int i = -1, j = -1;
        int min = Integer.MAX_VALUE;
        for (int k = 0; k < words.length; k++) {
            if (words[k].equals(word1) ) {
                if (j != -1 && i == -1) {
                    min = k - j;
                } else {
                    min = Math.min(min, k - j);
                }
                i = k;
            } else if (words[k].equals(word2)){
                if (i != -1 && j == -1) {
                    min = k - i;
                } else {
                    min = Math.min(min, k - i);
                }
                j = k;
            }
        }        
        return min;
    }
}