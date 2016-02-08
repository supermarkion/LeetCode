/*
    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

    Link: https://leetcode.com/problems/binary-tree-level-order-traversal/

    Example: 
    	Given binary tree {3,9,20,#,#,15,7},
		    3
		   / \
		  9  20
		    /  \
		   15   7
		return its level order traversal as:
		[
		  [3],
		  [9,20],
		  [15,7]
		]

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (! queue.isEmpty()) {
            List<Integer> tempIntList = new ArrayList<Integer>();
            List<TreeNode> tempNodeList = new ArrayList<TreeNode>();
            while (! queue.isEmpty()) {
                TreeNode node = queue.poll();
                tempIntList.add(node.val);
                tempNodeList.add(node);
            }
            result.add(tempIntList);
            for (TreeNode node : tempNodeList) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}