/*
    Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
        All letters in hexadecimal (a-f) must be in lowercase.
        The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
        The given number is guaranteed to fit within the range of a 32-bit signed integer.
        You must not use any method provided by the library which converts/formats the number to hex directly.

    Link: https://leetcode.com/problems/convert-a-number-to-hexadecimal/

    Example: 
		Example 1:

            Input:
            26

            Output:
            "1a"

        Example 2:

            Input:
            -1

            Output:
            "ffffffff"

    Solution: None

    Source: https://discuss.leetcode.com/topic/61049/java-solution-easy-to-understand-solution-with-comments
*/

public String toHex(int num) {
    if (num == 0) {
        return "0";
    } 
    String temp = "";

    while (num != 0) {
        int rem = (num % 16) & 15;   // compares last four binary digits of the num with F
        temp = (rem > 9 ? (char)('a' - 10 + rem) + "" : rem + "") + temp; // if remainder is 10, 11 and so on, converts it to 'a' , 'b' and so on..
        num = num >>> 4; // bitwise unsigned right shift by four binary digits
    }
    return temp;
}