/*
    Given a binary tree, return the inorder traversal of its nodes' values.

    Link: https://leetcode.com/problems/binary-tree-inorder-traversal/

    Example: For example:
		Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
		return [1,3,2].

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        // parentStack.push(root);
        while (! parentStack.empty() || root != null) {
            if (root != null) {
                parentStack.push(root);
                root = root.left;
            } else {
                root = parentStack.pop();
                result.add(root.val);
                root = root.right;
            }
        }
        return result;
    }
}