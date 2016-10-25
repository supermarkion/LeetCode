/*
    Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
    Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.   
    The order of output does not matter.

    Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/

    Example: 

        Example 1:

        Input:
        s: "cbaebabacd" p: "abc"

        Output:
        [0, 6]

        Explanation:
        The substring with start index = 0 is "cba", which is an anagram of "abc".
        The substring with start index = 6 is "bac", which is an anagram of "abc".

        Example 2:

        Input:
        s: "abab" p: "ab"

        Output:
        [0, 1, 2]

        Explanation:
        The substring with start index = 0 is "ab", which is an anagram of "ab".
        The substring with start index = 1 is "ba", which is an anagram of "ab".
        The substring with start index = 2 is "ab", which is an anagram of "ab".

    Solution: None

    Source: https://discuss.leetcode.com/topic/64609/java-16ms-solution
*/

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] log = new int[26];
        for (char ch : p.toCharArray()) {
            log[ch - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        char[] ss = s.toCharArray();
        int i = 0,j = 0;
        int[] log_copy = Arrays.copyOf(log, 26);
        while (i <= ss.length - p.length()) {
            boolean flag = true;
            while (j < i + p.length()) {
                int index = ss[j] - 'a';
                log_copy[index]--;
                if (log_copy[index] < 0) {
                    flag = false;
                    i = s.indexOf(ss[j], i) + 1;
                    log_copy = Arrays.copyOf(log, 26);
                    j = i;
                    break;
                }
                j++;
            }
            if (flag) {
                res.add(i);
                log_copy[ss[i] - 'a']++;
                i++;
            }
        }
        return res;
    }
}