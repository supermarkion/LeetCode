/*
    Given a non-negative number represented as an array of digits, plus one to the number. The digits are stored such 
    that the most significant digit is at the head of the list.
    
    Link: https://leetcode.com/problems/plus-one/

    Example: None

    Solution: None
    
    Source: https://leetcode.com/discuss/73311/0ms-java-solution-1-pass
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
        	return digits;
        }
            
        for (int i = digits.length - 1; i >= 0; i--){
            if (digits[i] != 9){
                digits[i]++;
                break;
            } else if (i == 0){
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            } else {
            	digits[i]=0;
            }
        }
        return digits;
    }
}