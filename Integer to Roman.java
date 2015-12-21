/*
    Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
    Link: https://leetcode.com/problems/integer-to-roman/
    Example: None
    Solution: None
    Source: None
*/

public class Solution {
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();
        String[] symbol = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for (int i = 0; num!= 0; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbol[i]);
            }
        }
        return sb.toString();
    }
}