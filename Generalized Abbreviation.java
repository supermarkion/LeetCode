/*
    Write a function to generate the generalized abbreviations of a word.

    Link: https://leetcode.com

    Example: 
    	Given word = "word", return the following list (order does not matter):
		["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]

    Solution: None

    Source: https://leetcode.com/discuss/93706/java-accepted-dp-solution
*/

public class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<String>();
        res.add(word);

        if (word.length() == 0) {
        	return res;
        }

        for (int i = 1; i <= word.length(); i++) {
            List<String> appends = generateAbbreviations(word.substring(i));

            for (String append : appends) {
                if (append.length() == 0 || (append.charAt(0) < '0' || append.charAt(0) > '9')) {
                	res.add("" + i + append);
                } else if (append.charAt(0) >= '0' && append.charAt(0) <= '9') {
                	res.add(word.substring(0, i) + append);
                }
            }
        }
        return res;
    }
}