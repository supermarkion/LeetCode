/*
    Given an array nums, there is a sliding window of size k which is moving from the very 
    left of the array to the very right. You can only see the k numbers in the window. Each 
    time the sliding window moves right by one position.
    
    Link: https://leetcode.com/problems/sliding-window-maximum/

    Example: For example,
		Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
		Window position                Max
		---------------               -----
		[1  3  -1] -3  5  3  6  7       3
		 1 [3  -1  -3] 5  3  6  7       3
		 1  3 [-1  -3  5] 3  6  7       5
		 1  3  -1 [-3  5  3] 6  7       5
		 1  3  -1  -3 [5  3  6] 7       6
		 1  3  -1  -3  5 [3  6  7]      7
		Therefore, return the max sliding window as [3,3,5,5,6,7].

    Solution: None
    
    Source: https://leetcode.com/discuss/83141/simple-approach-in-java-4ms-beats-97%25
*/

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int max = 0; //maximum of k elements in window
        int len = nums.length;
        int [] result;
        if (len == 1|| k == 0){
            return nums;
        }
        len = len - k + 1; // loop will execute 'len' times.
    
        result = new int[len];
    
        for (int i = 0; i < len ; i++){
            if (i == 0){
                max = getMax(nums, i, i + k - 1);  //linear search to get maximum of k values         
            } else {
                if (max == nums[i - 1]) {   //check whether the last number is max or not
                    max =  getMax(nums, i, i + k - 1); // get the new Max number
                } else if ( max < nums[i + k - 1]) { // whether previous max is less than the new kth number
                    max = nums[i + k - 1];
                }
            }
            result[i] = max;
    
        }
    
        return result;  
    }
    
    private static int getMax(int[] nums, int i, int w) {
        int max = nums[i];
    
        for(int j = i + 1; j <= w ; j++){
            if(max < nums[j])
                max = nums[j];
        }
        return max;
    }
}