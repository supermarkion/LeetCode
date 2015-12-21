/*
    Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
    Link: https://leetcode.com/problems/roman-to-integer/
    Example: None
    Solution: None
    Source: None
*/

public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> tempMap = new HashMap<Character, Integer>();
        tempMap.put('I', 1);
        tempMap.put('V', 5);
        tempMap.put('X', 10);
        tempMap.put('L', 50);
        tempMap.put('C', 100);
        tempMap.put('D', 500);
        tempMap.put('M', 1000);
        
        int result = tempMap.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i > -1; i--) {
            if (tempMap.get(s.charAt(i + 1)) <= tempMap.get(s.charAt(i))) {
                result += tempMap.get(s.charAt(i));
            } else {
                result -= tempMap.get(s.charAt(i));
            }
        }
        
        return result;
    }
}