/*
    Given a binary tree, find its maximum depth. The maximum depth is the number of nodes along the longest path from the root node down to 
    the farthest leaf node.

    Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
}