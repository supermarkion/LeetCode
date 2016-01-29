/*
    Follow up for problem "Populating Next Right Pointers in Each Node". What if the given tree could be 
    any binary tree? Would your previous solution still work?
    
    Link: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

    Example: For example,
		Given the following binary tree,
		         1
		       /  \
		      2    3
		     / \    \
		    4   5    7
		After calling your function, the tree should look like:
		         1 -> NULL
		       /  \
		      2 -> 3 -> NULL
		     / \    \
		    4-> 5 -> 7 -> NULL

    Solution: None
    
    Source: https://leetcode.com/discuss/81542/my-java-bfs-solution
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
        if (root == null) { 
        	return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while (queue.size() > 0) {
            int size = queue.size();
            TreeLinkNode pre = queue.remove();
            if (pre.left != null) { 
            	queue.add(pre.left);
            }
            if (pre.right != null) { 
            	queue.add(pre.right);
            }
    
            size = size - 1;
    
            for (int i = 0; i < size; i++) {
                pre.next = queue.remove();
                pre = pre.next;
                if (pre.left != null) { 
                	queue.add(pre.left);
                }
                if (pre.right != null) { 
                	queue.add(pre.right);
                }
            }
            pre.next = null;
            
        }
    }
}