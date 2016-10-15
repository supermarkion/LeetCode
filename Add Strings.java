/*
    Given two non-negative numbers num1 and num2 represented as string, return the sum of num1 and num2.

    Note:
        1. The length of both num1 and num2 is < 5100.
        2. Both num1 and num2 contains only digits 0-9.
        3. Both num1 and num2 does not contain any leading zero.
        4. You must not use any built-in BigInteger library or convert the inputs to integer directly.

    Link: https://leetcode.com/problems/add-strings/

    Example:  None

    Solution: None

    Source: https://discuss.leetcode.com/topic/62977/java-solution-o-n-running-time-o-n-memory-24ms
*/

public class Solution {
    public String addStrings(String num1, String num2) {
    
    int n = num1.length() - 1;
    int m = num2.length() - 1;

    final StringBuilder builder = new StringBuilder();

    int carry = 0;
    while (n >= 0 || m >= 0) {
        final int x = n >= 0 ? num1.charAt(n--) - '0' : 0;
        final int y = m >= 0 ? num2.charAt(m--) - '0' : 0;
        final int z = x + y + carry;
        if (z > 9) {
            builder.append(z - 10);
            carry = 1;
        } else {
            builder.append(z);
            carry = 0;
        }
    }
    if (carry > 0) {
        builder.append(carry);
    }
        return builder.reverse().toString();
    }
}