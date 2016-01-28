/*
    Two elements of a binary search tree (BST) are swapped by mistake. Recover the tree without changing its structure.

    Link: https://leetcode.com/problems/recover-binary-search-tree/

    Example: None

    Solution: None

    Source: https://leetcode.com/discuss/73227/4ms-java-solution
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
    TreeNode first = null, second = null, pre = null;

    public void recoverTree(TreeNode root) {
        if (root == null) {
        	return;
        }

        dfs(root);

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

    }

    public void dfs(TreeNode root){
        if (root.left != null) {
        	dfs(root.left);
        }
        if (pre != null && pre.val > root.val) {
            if (first == null) {
            	first = pre;
            }
            if (first != null) {
            	second = root;
            }
        }
        pre = root;
        if (root.right != null) {
        	dfs(root.right);
        }
    }
}