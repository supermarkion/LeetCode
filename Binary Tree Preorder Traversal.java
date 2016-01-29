/*
    Given a binary tree, return the preorder traversal of its nodes' values.
    
    Link: https://leetcode.com/problems/binary-tree-preorder-traversal/

    Example: For example:
		Given binary tree {1,#,2,3},
		   1
		    \
		     2
		    /
		   3
		return [1,2,3].

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> parentStack = new Stack<TreeNode>();
        while (! parentStack.empty() || root != null) {
            if (root != null) {
                result.add(root.val);
                if (root.right != null) {
                    parentStack.push(root.right);
                }
                root = root.left;
            } else {
                root = parentStack.pop();
            }
        }
        return result;
    }
}