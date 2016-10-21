/*
    Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
        Note:
        Input contains only lowercase English letters.
        Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
        Input length is less than 50,000.

    Link: https://leetcode.com/problems/reconstruct-original-digits-from-english/

    Example: 

        Example 1:
        Input: "owoztneoer"

        Output: "012"
        Example 2:
        Input: "fviefuro"

        Output: "45"

    Solution: None

    Source: https://discuss.leetcode.com/topic/63386/one-pass-o-n-java-solution-simple-and-clear
*/

public class Solution {
    static String[] digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static char[] ids = {'z', 'o', 'w', 'h', 'u', 'f', 'x', 's', 'g', 'i'};
    static int[] order = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
    
    public String originalDigits(String s) {
        int[] dCount = new int[10], lCount = new int[26];
        
        for (char c : s.toCharArray()) {
            lCount[c - 'a']++;
        }

        for (int d : order) {
            dCount[d] = lCount[ids[d] - 'a'];
            for (char c : digits[d].toCharArray()) {
                lCount[c - 'a'] -= dCount[d];
            } 
        }
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < dCount[i]; ++j) {
                ans.append(i);
            }
        }
        return ans.toString();
    }
}