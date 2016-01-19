/*
    Given a binary tree, determine if it is height-balanced. For this problem, a height-balanced binary tree is defined as 
    a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

    Link: https://leetcode.com/problems/balanced-binary-tree/

    Example: None

    Solution: We set when facing error, we return −1 to upper layer. And when the upper layer get −1, and we will know
    that there is a error.

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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root) != -1;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);
        if (leftDepth == -1 || rightDepth == -1 ||
            Math.abs(rightDepth - leftDepth) > 1) {
                return -1;
            }
        return 1 + Math.max(leftDepth, rightDepth);
        }
}