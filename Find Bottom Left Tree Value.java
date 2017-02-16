/*
	Given a binary tree, find the leftmost value in the last row of the tree.

    Link: https://leetcode.com/problems/find-bottom-left-tree-value/

	Example: 
		Example 1:
		Input:

		    2
		   / \
		  1   3

		Output:
		1
		
		Example 2: 
		Input:

		        1
		       / \
		      2   3
		     /   / \
		    4   5   6
		       /
		      7

		Output:
		7
				
    Solution: None

    Source: https://discuss.leetcode.com/topic/79577/standard-bfs-in-java
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
    public int findBottomLeftValue(TreeNode root) {
        /*any initial value is valid*/
        int result = -1;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            result = queue.peek().val;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }
        return result;
    }
}