/*
    Given a binary tree, flatten it to a linked list in-place.
    
    Link: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

    Example: For example,
		Given

		         1
		        / \
		       2   5
		      / \   \
		     3   4   6
		The flattened tree should look like:
		   1
		    \
		     2
		      \
		       3
		        \
		         4
		          \
		           5
		            \
		             6

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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                p.right = p.left;
                p.left = null;
            } else if (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                p.right = temp;
            }
            p = p.right;
        }

    }
}