/*
	You need to find the largest value in each row of a binary tree.

    Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/

	Example: 
		Input: 

		          1
		         / \
		        3   2
		       / \   \  
		      5   3   9 

		Output: [1, 3, 9]
				
    Solution: None

    Source: https://discuss.leetcode.com/topic/79278/java-solution
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
    public List<Integer> largestValues(TreeNode root) {
       List<Integer> result = new LinkedList<>();
    	if (root == null) {
    		return result;
    	}
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.offer(root);
    	while (!queue.isEmpty()){
	        int level = queue.size();
	        int max_value = Integer.MIN_VALUE;
	        for (int i = 0; i < level; i++){
	            TreeNode node = queue.poll();
	            if (node.val > max_value) {
	                max_value = node.val;
	            }
	            if (node.left != null) {
	            	queue.offer(node.left);
	            }
	            if (node.right != null) {
	            	queue.offer(node.right);
	            }
	        }
	        result.add(max_value);
	    }
    	return result;
    }
}