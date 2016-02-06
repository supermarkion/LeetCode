/*
    Find the contiguous subarray within an array (containing at least one number) which has the largest product.
    
    Link: https://leetcode.com/problems/maximum-product-subarray/

    Example: For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.

    Solution: The product result is special because its result can change from minimum to maximum only by multiply
	a negative number. Therefore, we update two list, which save minimum product and maximum product
	numbers. Once we meet a new positivity number, we compare two list themselves, but if we meet a negative
	number, we update the list based on different list.
    
    Source: None
*/

public class Solution {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        min[0] = max[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = max[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * nums[i]);
                min[i] = Math.min(min[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * nums[i]);
                min[i] = Math.min(min[i], max[i - 1] * nums[i]);
            }
            
            result = Math.max(result, max[i]);
        }
        
        return result;
    }
}
