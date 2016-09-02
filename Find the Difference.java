/*
    Given two strings s and t which consist of only lowercase letters.
	
	String t is generated by random shuffling string s and then add one more letter at a random position.

	Find the letter that was added in t.
    
    Link: https://leetcode.com/problems/find-the-difference/

    Example: 
    	Input:
		s = "abcd"
		t = "abcde"

		Output:
		e

		Explanation:
		'e' is the letter that was added.

    Source: https://discuss.leetcode.com/topic/56563/java-solution-using-list
*/

public class Solution {
    public char findTheDifference(String s, String t) {
        List<Character> ls = new ArrayList<>();
        for (int i = 0; i < t.length(); i++){
            ls.add(t.charAt(i));
        }

        Character c;
        for (int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            ls.remove(c);
        }
        return ls.get(0);
    }
}