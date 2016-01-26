/*
    Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
	If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
	The replacement must be in-place, do not allocate extra memory.
    
    Link: https://leetcode.com/problems/next-permutation/

    Example: Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
		1,2,3 → 1,3,2
		3,2,1 → 1,2,3
		1,1,5 → 1,5,1

    Solution: In the problem on Permutation, the main process is to find the value which is greater or less than current
	digit, and then swap them. But this time, it is not enough, we should reverse the values from least values
	because we should get the maximum value following this digital. In the other word, we find a[k] < a[k + 1],
	then find a[k] < a[l], and swap k and l, and reverse k + 1 to end. For the previous part, it change to
	a[k] > a[k + 1] and a[k] > a[l].
    
    Source: None
*/

public class Solution {
    public void nextPermutation(int[] nums) {
        if ( nums == null || nums.length < 2) {
            return;
        }
        int len = nums.length;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                int j;
                for (j = len - 1; j > i - 1; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
                swap(nums, i , j) ;
                reverse(nums, i + 1, len - 1) ;
                return;
            }
        }
        reverse(nums, 0, len - 1) ;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
}