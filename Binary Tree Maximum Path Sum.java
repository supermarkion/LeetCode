/*
    Given a binary tree, find the maximum path sum. For this problem, a path is defined as any sequence of nodes from some 
    starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

    Link: https://leetcode.com/problems/binary-tree-maximum-path-sum/

    Example: 
	    Given the below binary tree,

	       1
	      / \
	     2   3
	Return 6.

    Solution: Use recursion to avoid the process on DFS.

    Source: https://leetcode.com/discuss/77619/2ms-java-solution-without-using-global-variable
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
    public int maxPathSum(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode dummy = new TreeNode(root.val);
        maxPathSumThroughNode(root, dummy);
        return dummy.val;
    }
    
    private int maxPathSumThroughNode(TreeNode root, TreeNode dummy) {
        if (root == null)
            return 0;
        int left = Math.max(0, maxPathSumThroughNode(root.left, dummy));
        int right = Math.max(0, maxPathSumThroughNode(root.right, dummy));
        dummy.val = Math.max(dummy.val, root.val + left + right);
        return Math.max(Math.max(left, right) + root.val, root.val);
    }
}