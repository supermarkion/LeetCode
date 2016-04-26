/*
    Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) 
    or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new 
    root.
    
    Link: https://leetcode.com/problemset/algorithms/

    Example: 
	    For example:
		Given a binary tree {1,2,3,4,5},
		 1
		/ \
	   2   3
		  / \
		 4   5

		return the root of the binary tree [4,5,2,#,#,3,1].
		 4
		/ \
	   5   2
		  / \
		 3   1
	
    Solution: None

    Source: http://blog.csdn.net/whuwangyi/article/details/43186045
*/

public TreeNode UpsideDownBinaryTree(TreeNode root) {  
    if (root == null) {
    	return null; 
    }  
    TreeNode parent = root, left = root.left, right = root.right;  
    if (left != null) {  
        TreeNode ret = UpsideDownBinaryTree(left);  
        left.left = right;  
        left.right = parent;  
        return ret;  
    }  
    return root;  
}  