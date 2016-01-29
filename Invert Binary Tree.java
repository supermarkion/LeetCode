/*
    Invert a binary tree.
	     4
	   /   \
	  2     7
	 / \   / \
	1   3 6   9
	to
	     4
	   /   \
	  7     2
	 / \   / \
	9   6 3   1

    
    Link: https://leetcode.com/problems/invert-binary-tree/

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        swapNodes(root);
        return root;
    }

    public void swapNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        swapNodes(root.left);
        swapNodes(root.right);
    }

}