/*
    Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
    
    Link: https://leetcode.com/problems/add-digits/

    Example: For example:
		Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. 
		Since 2 has only one digit, return it.

    Solution: None
    
    Source: https://leetcode.com/discuss/80037/java-one-line-simple-answer
*/

public class Solution {
    public int addDigits(int num) {
        // For number that from 0 to 9, the answer is themselves
        // For number that is divisible by 9, the answer is 9
        // Otherwise, the answer is the reminder after divided by 9
        return num > 9 ? (num % 9 == 0 ? 9 : num % 9) : num;
    }
}