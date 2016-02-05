/*
    Given an array of integers, every element appears three times except for one. Find that single one.

    Link: https://leetcode.com/problems/single-number-ii/

    Example: None

    Solution: Given an array of integers, every element appears k times except for one. Find that single one which appears
	l times. We need a array x[i] with size k for saving the bits appears i times. For every input number a,
	generate the new counter by x[j] = (x[j − 1]&a)|(x[j]& a). Except x[0] = (x[k]&a)|(x[0]& a).
    
    Source: None
*/

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int k = 3;
        int l = 1;
        int t;
        int[] x = new int[k];
        x[0] = ~0;
        for (int i = 0; i < nums.length; i++) {
            t = x[k - 1];
            for (int j = k - 1; j > 0; j--) {
                x[j] = (x[j - 1] & nums[i]) | (x[j] & ~nums[i]);
            }
            x[0] = (t & nums[i]) | (x[0] & ~nums[i]);
        }
        return x[l];
    }
}

public class Solution {
	public static int singleNumber(int[] nums) {
		// use 32 bit number defintion to find single number.
	    int len = nums.length, result = 0;
	    for (int i = 0; i < 32; i++) {
	        int sum = 0;
	        for (int j = 0; j < len; j++) {
	            sum += (nums[j] >> i) & 1;
	        }
	        result |= (sum % 3) << i;
	    }
	    return result;
	}
}