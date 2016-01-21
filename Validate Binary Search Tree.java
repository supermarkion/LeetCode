/*
    Given a binary tree, determine if it is a valid binary search tree (BST). Assume a BST is defined as follows:
		The left subtree of a node contains only nodes with keys less than the node's key.
		The right subtree of a node contains only nodes with keys greater than the node's key.
		Both the left and right subtrees must also be binary search trees.

    Link: https://leetcode.com/problems/validate-binary-search-tree/

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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (root.val >= upper || root.val <= lower) {
            return false;
        }
        boolean isleftValidBST = helper(root.left, lower, root.val);
        boolean isrightValidBST = helper(root.right, root.val, upper);
        return isleftValidBST && isrightValidBST;
    }
}