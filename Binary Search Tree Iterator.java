/*
    Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
	Calling next() will return the next smallest number in the BST.

    Link: https://leetcode.com/problems/binary-search-tree-iterator/

    Example: None

    Solution: None
    
    Source: None
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode curt;

    public BSTIterator(TreeNode root) {
        curt = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
         return (curt != null || !stack.isEmpty()); //important to judge curt != null
    }

    /** @return the next smallest number */
    public int next() {
        while (curt != null) {
            stack.push(curt);
            curt = curt.left;
        }
        curt = stack.pop();
        TreeNode node = curt;
        curt = curt.right;
        return node.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */