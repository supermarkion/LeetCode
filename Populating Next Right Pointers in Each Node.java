/*
    Given a binary tree
	    struct TreeLinkNode {
	      TreeLinkNode *left;
	      TreeLinkNode *right;
	      TreeLinkNode *next;
	    }
	Populate each next pointer to point to its next right node. If there is no next right node, the next pointer 
	should be set to NULL. Initially, all next pointers are set to NULL.
    
    Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

    Example: For example,
		Given the following perfect binary tree,
		         1
		       /  \
		      2    3
		     / \  / \
		    4  5  6  7
		After calling your function, the tree should look like:
		         1 -> NULL
		       /  \
		      2 -> 3 -> NULL
		     / \  / \
		    4->5->6->7 -> NULL

    Solution: None
    
    Source: None
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
        	return;
        }
        root.next = null;
        TreeLinkNode current = root;
        connectNodes(current);
    }

    public void connectNodes(TreeLinkNode current){

        if(current == null || (current.left == null && current.right == null)) {
        	return;
        }

        current.left.next = current.right;
        if(current.next != null) {
        	current.right.next = current.next.left;
        } else {
        	current.right.next = null;
        }
        connectNodes(current.left);
        connectNodes(current.right);
    }
}