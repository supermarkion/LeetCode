/*
    Given a non-empty string str and an integer k, rearrange the string such that the same characters 
    are at least distance k from each other. All input strings are given in lowercase letters. If it 
    is not possible to rearrange the string, return an empty string "".
    
    Link: https://leetcode.com/problemset/algorithms/

    Example: 
    	Example 1:
		str = "aabbcc", k = 3
		Result: "abcabc"

		The same letters are at least distance 3 from each other.
		Example 2:
		str = "aaabc", k = 3 

		Answer: ""

		It is not possible to rearrange the string.
		Example 3:
		str = "aaadbbcc", k = 2

		Answer: "abacabcd"

		Another possible answer is: "abcabcda"
		The same letters are at least distance 2 from each other.
    
    Solution: None

    Source: https://leetcode.com/discuss/108530/java-15ms-solution-with-two-auxiliary-array-o-n-time
*/

public class Solution {
    public String rearrangeString(String str, int k) {
        int length = str.length();
        int[] count = new int[26];
        int[] valid = new int[26];
        for (int i = 0; i < length; i++) {
            count[str.charAt(i) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int index = 0;index < length;index++) {
            int candidatePos = findValidMax(count, valid, index);
            if (candidatePos == -1) {
            	return "";	
            }
            count[candidatePos]--;
            valid[candidatePos] = index + k;
            sb.append((char)('a' + candidatePos));
        }
        return sb.toString();
    }

   private int findValidMax(int[] count, int[] valid, int index){
       int max = Integer.MIN_VALUE;
       int candidatePos = -1;
       for (int i = 0; i < count.length; i++) {
           if (count[i] > 0 && count[i] > max && index >= valid[i]) {
               max = count[i];
               candidatePos = i;
           }
       }
       return candidatePos;
   }
}