 /*
    You are playing the following Flip Game with your friend: Given a string that contains only these two characters: 
    + and -, you and your friend take turns to flip twoconsecutive "++" into "--". The game ends when a person can no 
    longer make a move and therefore the other person will be the winner. Write a function to compute all possible 
    states of the string after one valid move.
    
    Link: https://leetcode.com/problemset/algorithms/

    Example: 
		For example, given s = "++++", after one move, it may become one of the following states:
            [
              "--++",
              "+--+",
              "++--"
            ]
        If there is no valid move, return an empty list [].
	
    Solution: None

    Source: http://buttercola.blogspot.com.au/2015/10/leetcode-flip-game.html
*/

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 2) {
            return result;
        }
         
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String s1 = s.substring(0, i);
                String s2 = "--";
                String s3 = s.substring(i + 2);
                String temp = s1 + s2 + s3;
                result.add(temp);
            }
        }
         
        return result;
    }
}