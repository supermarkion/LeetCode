/*
    Find the sum of all left leaves in a given binary tree.

    Link: https://leetcode.com/problems/sum-of-left-leaves/

    Example: 

            3
           / \
          9  20
            /  \
           15   7

        There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

    Solution: None

    Source: https://leetcode.com/problems/sum-of-left-leaves/
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
    int toRet;
    public int sumOfLeftLeaves(TreeNode root) 
    {
        toRet = 0;
        dfs(root, -1);
        return toRet;
    }
    void dfs(TreeNode root, int dir)
    {
        if (root == null) {
          return;
        }
            
        if (dir == 0 && root.left == null && root.right == null) {
            toRet += root.val;
            return;
        }
        dfs(root.left, 0);
        dfs(root.right, 1);
    }
}