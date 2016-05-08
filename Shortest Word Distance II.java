/*
    This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method 
    will be called repeatedly many times with different parameters. How would you optimize it? 

	Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and 
	word2 and return the shortest distance between these two words in the list. 
    
    Link: https://leetcode.com/problemset/algorithms/

    Example:  
		Assume that words = ["practice", "makes", "perfect", "coding", "makes"]. 

		Given word1 = “coding”, word2 = “practice”, return 3. 
		Given word1 = "makes", word2 = "coding", return 1. 
    
    Solution: None

    Source: http://blog.csdn.net/crazy__chen/article/details/47859865
*/

public class WordDistance {
    private HashMap<String, List<Integer>> indexer = new HashMap<String, List<Integer>>();
    public WordDistance(String[] words) {
        if (words == null) {
        	return;
        }
        for (int i = 0; i < words.length; i++) {
            if (indexer.containsKey(words[i])) {
                indexer.get(words[i]).add(i);
            } else {
                List<Integer> positions = new ArrayList<Integer>();
                positions.add(i);
                indexer.put(words[i], positions);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> posList1 = indexer.get(word1);
        List<Integer> posList2 = indexer.get(word2);
        int i = 0, j = 0;
        int diff = Integer.MAX_VALUE;
        while (i < posList1.size() && j < posList2.size()) {
            int pos1 = posList1.get(i), pos2 = posList2.get(j);
            if (pos1 < pos2) {
                diff = Math.min(diff, pos2 - pos1);
                i++;
            } else {
                diff = Math.min(diff, pos1 - pos2);
                j++;
            }
        }
        return diff;
    }
}
