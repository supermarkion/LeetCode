/*
    Implement atoi to convert a string to an integer.

    Link: https://leetcode.com/problems/string-to-integer-atoi/

    Example: None

    Solution: In this method, we should consider of following items.
		• first discards as many whitespace characters as necessary until the first non-whitespace character is
		found
		• starting from this character, takes an optional initial plus or minus sign followed by as many numerical
		digits as possible, , and interprets them as a numerical value
		• The string can contain additional characters after those that form the integral number, which are
		ignored and have no effect on the behavior of this function
		• If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such
		sequence exists because either str is empty or it contains only whitespace characters, no conversion is
		performed enditemize
    
    Source: None
*/

public class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int sign = 1;
        int index = 0;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        long result = 0;
        for (; index < str.length(); index++) {
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break; // meet not number element, we stop atoi
            }
            result = result * 10 + (str.charAt(index) - '0');
            if (result * sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            if (result * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
        }
        if (result * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        if (result * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)result * sign;
    }
}