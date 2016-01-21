/*
    Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

    Link: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

    Example: None

    Solution: None

    Source: None
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int low, int high) {
    
        if (low >= high) {
           return null; 
        }
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, low, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, high);
    
        return node;
    
    }
}