/*
    Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the 
    product of all the elements of nums except nums[i].
    
    Link: https://leetcode.com/problems/product-of-array-except-self/

    Example: For example, given [1,2,3,4], return [24,12,8,6].

    Solution: None
    
    Source: None
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res[0] = 1;
            return res;
        }
        int[] lProduct = new int[nums.length];
        int[] rProduct = new int[nums.length];
        lProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            lProduct[i] = lProduct[i - 1] * nums[i - 1];
        }
        rProduct[nums.length - 1] = 1;
        for (int j = nums.length - 2; j >= 0; j--) {
            rProduct[j] = rProduct[j + 1] * nums[j + 1];
        }
        for (int k = 0; k < nums.length; k++) {
            res[k] = lProduct[k] * rProduct[k];
        }
        return res;
    }
}