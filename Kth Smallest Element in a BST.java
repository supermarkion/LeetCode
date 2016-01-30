/*
    Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
    
    Link: https://leetcode.com/problems/kth-smallest-element-in-a-bst/

    Example: None

    Solution: Based on the defintion of BST, the smaller elements is in left branch.
    
    Source: https://leetcode.com/discuss/81604/java-solution-using-iterative-inorder-traversal
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stack.empty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k--;
            if (k == 0) {
            	return node.val;
            }
            node = node.right;
        }
        return -1;
    }
}