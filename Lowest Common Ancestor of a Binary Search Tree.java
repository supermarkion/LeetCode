/*
    Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
    
    Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    Example: 
	        _______6______
	       /              \
	    ___2__          ___8__
	   /      \        /      \
	   0      _4       7       9
	         /  \
	         3   5

    For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of 
    nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

    Solution: if both child-branch not exists, it is itself, if exits left, it is left, or right.
    (because BST, the left is always smaller than other branches.)
    
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        if (root == p || root == q) {
            return root;
        } else {
            TreeNode l = lowestCommonAncestor(root.left, p, q);
            TreeNode r = lowestCommonAncestor(root.right, p, q);
            if (l != null && r != null) {
                return root;
            } else if (l != null) {
                return l;
            } else {
                return r;
            }
        }
    }
}