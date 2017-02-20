/*
	Given an integer, return its base 7 string representation.
    
    Link: https://leetcode.com/problems/base-7/?tab=Description

	Example: 
		Example 1:
		Input: 100
		Output: "202"
		
		Example 2:
		Input: -7
		Output: "-10"
				
    Solution: None

    Source: https://discuss.leetcode.com/topic/79831/my-java-solution-without-reverse
*/

public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
        	return "0";
        }
        boolean isNagative = true;
        if (num >= 0) {
        	isNagative = false;
        }
        num = Math.abs(num);
        int [] base7 = {1, 7, 49, 343, 2401, 16807, 117649, 823543, 5764801, 40353607, 282475249};
        StringBuilder result = new StringBuilder(11); 
        int i = 10;
        for (; i >= 0; i--) {
            int digit = num / base7[i];
            result.append(digit);
            num -= digit * base7[i];
        } 
        while (result.charAt(++i) == '0');
        return isNagative ? "-" + result.substring(i) : result.substring(i);
    }
}