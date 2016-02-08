/*
    Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence 
    from beginWord to endWord, such that:
		Only one letter can be changed at a time
		Each intermediate word must exist in the word list

    Link: https://leetcode.com/problems/word-ladder/

    Example: Given:
		beginWord = "hit"
		endWord = "cog"
		wordList = ["hot","dot","dog","lot","log"]
		As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
		return its length 5.

    Solution: Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from
	start to end. We apply BFS to solve. It contains following steps:
		• construct a queue, and a hash to save passed node word
		• use a method named getNextWords to get the neighbour word list based on current word.
		• it we passed this word, ignore it.
    
    Source: None
*/

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord == null && endWord == null) {
            return 0;
        }
        if (beginWord.length() == 0 && endWord.length() == 0) {
            return 0;
        }
        assert(beginWord.length() == endWord.length());
        if (wordList == null || wordList.size() == 0) {
            return 0;   
        }
        int ladderLen = 1;
        wordList.add(endWord);
        Queue<String> q = new LinkedList<String>();
        Set<String> hash = new HashSet<String>();
        q.offer(beginWord);
        hash.add(beginWord);
        while (!q.isEmpty()) {
            ladderLen++;
            int qLen = q.size();
            for (int i = 0; i < qLen; i++) {
                String strTemp = q.poll();
                for (String nextWord : getNextWords(strTemp, wordList)) {
                    if (nextWord.equals(endWord)) {
                        return ladderLen;
                    }
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    q.offer(nextWord);
                    hash.add(nextWord);
                }
            }
        }
        return 0;
    }
    
    private Set<String> getNextWords(String curr, Set<String> wordList) {
    	// construct next word based on given word
        Set<String> nextWords = new HashSet<String>();
        for (int i = 0; i < curr.length(); i++) {
            char[] chars = curr.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String temp = new String(chars);
                if (wordList.contains(temp)) {
                    nextWords.add(temp);		// add all possible words
                }
            }
        }
        return nextWords;
    }
}