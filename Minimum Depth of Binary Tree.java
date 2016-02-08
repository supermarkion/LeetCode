/*
    Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the shortest path 
    from the root node down to the nearest leaf node.

    Link: https://leetcode.com/problems/minimum-depth-of-binary-tree/

    Example: None

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left != null && root.right != null) { 					// when we can move to next level
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;		// two branch are not equal
        } else {																// when one branch is meet end
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;	
        }
    }
}