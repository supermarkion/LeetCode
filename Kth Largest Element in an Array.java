/*
    Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, 
    not the kth distinct element.

    Link: https://leetcode.com/problems/kth-largest-element-in-an-array/

    Example: Given [3,2,1,5,6,4] and k = 2, return 5.

    Solution: None
    
    Source: None
*/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (k < 1 || nums == null) {
            return 0;
        }
        return getKth(nums, nums.length- k + 1, 0, nums.length - 1);
        
    }
    public int getKth(int[] nums, int k, int start, int end) {
        int pivot = nums[end];
        int left = start;
        int right = end;
        while (true) {
            while (nums[left] < pivot && nums[left] < nums[right]) {
                left++;
            }
            while (nums[right] >= pivot && right > left) {
                right--;
            }
            if (left == right) {
                break;
            }
            swap(nums, left, right);
        }
        swap(nums, left, end);
        if (k == left + 1) {
            return pivot;
        } else if (k < left + 1) {
            return getKth(nums, k, start, left - 1);
        } else {
            return getKth(nums, k, left + 1, end);
        }
    }
    public void swap(int[] nums, int n1, int n2) {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
}