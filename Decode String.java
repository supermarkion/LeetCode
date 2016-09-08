/*
    Given an encoded string, return it's decoded string. The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is 
    being repeated exactly k times. Note that k is guaranteed to be a positive integer.
	
	You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
	
	Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, 
	there won't be input like 3a or 2[4].
    
    Link: https://leetcode.com/problems/decode-string/

    Example: 
		s = "3[a]2[bc]", return "aaabcbc".
		s = "3[a2[c]]", return "accaccacc".
		s = "2[abc]3[cd]ef", return "abcabccdcdcdef".

    Source: https://discuss.leetcode.com/topic/57840/java-3ms-recursive-solution-no-stack
*/

public class Solution {
    public String decodeString(String s) {
        return explore(s, 0, s.length());
    }
    
    String explore(String s, int start, int end) {
        if (start >= end) return "";
        int time = 0;
        int i = start;
        //calculate repeating time
        while (i < end && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            time = time * 10 + (int)(s.charAt(i++)-'0');
        }
        StringBuilder sb = new StringBuilder();
        int nextstart = i;
        if (time == 0) {
            //don't need to repeat
            while (i < end && (s.charAt(i) >= '9' || s.charAt(i) <= '0')) {
                sb.append(s.charAt(i++));
            }
        } else {
            int cntBracket = 1;
            i++;
            int newstart = i;
            while (i < end && cntBracket > 0) {
                if (s.charAt(i) == ']') {
                    --cntBracket;
                } else if (s.charAt(i) == '[') {
                    ++cntBracket;
                }
                i++;
            }
            String inside = explore(s, newstart, i-1);
            //repaet the inside string
            while (time-- > 0) {
                sb.append(inside);
            }
        }
        sb.append(explore(s, i, end));
        return sb.toString();     
    }
}