/*
    Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
    word1 and word2 may be the same and they represent two individual words in the list.
    
    Link: https://leetcode.com/problemset/algorithms/

    Example:  
        Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
        Given word1 = “makes”, word2 = “coding”, return 1.
        Given word1 = "makes", word2 = "makes", return 3. 
    
    Solution: None

    Source: http://www.cnblogs.com/anne-vista/p/4831092.html
*/

public int shortestWordDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, distance = words.length;
        
        for (int i = 0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
                if (p1 != -1 && p2 != -1) {
                    distance = (p1 != p2) ? Math.min(distance, Math.abs(p1 - p2)): distance;
                }
            }
            if (words[i].equals(word2)) {
                p2 = i;
                if (p1 != -1 && p2 != -1){
                    distance = (p1 != p2) ? Math.min(distance, Math.abs(p1 - p2)): distance;
                }
            }
        }
        return distance;
    }