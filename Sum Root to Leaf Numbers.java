/*
    Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number. 
    An example is the root-to-leaf path 1->2->3 which represents the number 123. Find the total sum of 
    all root-to-leaf numbers.

    Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/

    Example: For example,
		    1
		   / \
		  2   3
		The root-to-leaf path 1->2 represents the number 12.
		The root-to-leaf path 1->3 represents the number 13.
		Return the sum = 12 + 13 = 25.

    Solution: None
    
    Source: https://leetcode.com/discuss/76459/0ms-java-recursive-solution
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
    public int sumNumbers(TreeNode root) {
        return leafNumbers(root,0);
    }
    public int leafNumbers(TreeNode node, int sum) {
        if (node == null) {
        	return 0;
        }
        int temp = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
        	return temp;
        }
        return leafNumbers(node.left,temp) + leafNumbers(node.right,temp);
    }
}