/*
    Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

    Link: https://leetcode.com/problems/integer-to-english-words/

    Example: For example,
		123 -> "One Hundred Twenty Three"
		12345 -> "Twelve Thousand Three Hundred Forty Five"
		1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
		Show Hint 

    Solution: Similar to Rome to Int or Int to Rome.
    
    Source: https://leetcode.com/discuss/77742/java-easy-version-to-understand
*/

public class Solution {
     static String[] lessThan20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
    static String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
    static String[] thousands = { "", "Thousand", "Million", "Billion" };
    
    public static String helper(int number) {
        if (number == 0)
            return "";
        if (number < 20)
            return lessThan20[number] + " ";
        if (number < 100)
            return tens[number / 10] + " " + helper(number % 10);
        else
            return lessThan20[number / 100] + " Hundred " + helper(number % 100);
    }
    
    public static String numberToWords(int num) {
        if (num == 0)
            return "Zero";
        String word = "";
        for (int i = 0; i < thousands.length; i++) {
            int tmp = num % 1000;
            num /= 1000;
            if (tmp == 0)
                continue;
            word = helper(tmp) + thousands[i] + " " + word;
        }
        return word.trim();
    }
}