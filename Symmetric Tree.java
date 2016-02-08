/*
    Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

    Link: https://leetcode.com/problems/symmetric-tree/

    Example: For example, this binary tree is symmetric:
		    1
		   / \
		  2   2
		 / \ / \
		3  4 4  3
		But the following is not:
		    1
		   / \
		  2   2
		   \   \
		   3    3

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
    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }

    private boolean isSym(TreeNode L, TreeNode R) {
        if (L == null && R == null) {
            return true;
        }
        if (L != null && R != null && L.val == R.val) {
            return isSym(L.left, R.right) && isSym(L.right, R.left);
        }
        return false;
    }
}