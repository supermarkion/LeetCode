 /*
    Given a binary tree, find the length of the longest consecutive sequence path.

	The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
	The longest consecutive path need to be from parent to child (cannot be the reverse).
    
    Link: https://leetcode.com/problemset/algorithms/

    Example: 
		   1
		    \
		     3
		    / \
		   2   4
		        \
		         5 

		Longest consecutive sequence path is 3-4-5, so return 3.

		   2
		    \
		     3
		    / 
		   2    
		  / 
		 1 

		Longest consecutive sequence path is 2-3,not 3-2-1, so return 2.
	
    Solution: None

    Source: https://segmentfault.com/a/1190000003957798
*/

public class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return findLongest(root, 0, root.val - 1);
    }
    
    private int findLongest(TreeNode root, int length, int preVal){
        if (root == null) {
            return length;
        }
        int currLen = preVal + 1 == root.val ? length + 1 : 1;
        return Math.max(currLen, Math.max(findLongest(root.left, currLen, root.val), findLongest(root.right, currLen, root.val)));  
    }
}