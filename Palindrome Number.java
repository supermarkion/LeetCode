/*
    Determine whether an integer is a palindrome. Do this without extra space.
    
    Link: https://leetcode.com/problems/palindrome-number/

    Example: None

    Solution: None
    
    Source: https://leetcode.com/discuss/82042/fast-java-solution
*/

public class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0) {
        	return false;
        }
            
        int b = 0;
        int temp =x;
    
        while (temp != 0) {
            b = temp % 10 + b * 10;
            temp /= 10;
        }
        return b == x;
    }
}