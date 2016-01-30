/*
    Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    
    Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

    Example: 
	        _______3______
           /              \
        ___5__          ___1__
       /      \        /      \
       6      _2       0       8
             /  \
             7   4
    For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is 
    LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the 
    LCA definition.

    Solution: None
    
    Source: https://leetcode.com/discuss/71092/easy-9-line-java-solution-o-n-time-using-recursion
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
            return null;
        }
        if (root == p) {
            return p;
        }
        if (root == q) {
            return q;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right != null) {
            return right;
        }
        return root;
    }
}