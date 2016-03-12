/*
    The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." 
    Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in 
    this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on 
    the same night. Determine the maximum amount of money the thief can rob tonight without alerting the police.
    
    Link: https://leetcode.com/problems/house-robber-iii/

    Example: 
    	Example 1:
		     3
		    / \
		   2   3
		    \   \ 
		     3   1
		Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

		Example 2:
		     3
		    / \
		   4   5
		  / \   \ 
		 1   3   1
		Maximum amount of money the thief can rob = 4 + 5 = 9.

    Solution: None

    Source: https://leetcode.com/discuss/91756/simple-1ms-java-solution-with-easy-comments
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
    public int rob(TreeNode root) {
        int[] result = findMax(root);
        return Math.max(result[0], result[1]);
    }

    // returns int[2] result. 
    // result[0] -- max value robbing current root; result[1] -- max value without robbing current root.
    private int[] findMax(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = findMax(root.left);
        int[] right = findMax(root.right);
        int result0 = root.val + left[1] + right[1];  								// rob current root
        int result1 = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);  	// not rob current root
        return new int[] {result0, result1};
    }
}