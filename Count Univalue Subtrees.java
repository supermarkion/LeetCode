/*
    Given a binary tree, count the number of uni-value subtrees.
	A Uni-value subtree means all nodes of the subtree have the same value.
    
    Link: https://leetcode.com/problemset/algorithms/

    Example:  
        Given binary tree,
              5
             / \
            1   5
           / \   \
          5   5   5
		return 4.
    
    Solution: None

    Source: http://blog.csdn.net/pointbreak1/article/details/48998407
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
    public int countUnivalSubtrees(TreeNode root) {
        unival(root);
        return count;
    }
    
    private boolean unival(TreeNode root) {
        if (root == null)
            return true;
        if (root.left == null && root.right == null) {
            count++;
            return true;
        }
        boolean left = unival(root.left);
        boolean right = unival(root.right);
        if (left && right && (root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
            count++;
            return true;
        }
        return false;
    }
    
    private int count = 0;
}