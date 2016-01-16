/*
    Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
    
    Link: hhttps://leetcode.com/problems/path-sum-ii/

    Example: 
	    Given the below binary tree and sum = 22,
	              5
	             / \
	            4   8
	           /   / \
	          11  13  4
	         /  \    / \
	        7    2  5   1
	return
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]

    Solution: None
    
    Source: https://leetcode.com/discuss/71055/3ms-java-solution
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
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    int sum;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.sum = sum;
        List<Integer> path = new ArrayList<Integer>();
        if (root == null) {
        	return res;
        }
        dfs(root, 0, path);
        return res;
    }
    private void dfs(TreeNode current, int curSum, List<Integer> path){
        path.add(current.val);
        curSum += current.val;
        if(current.left == null && current.right == null){
            if(curSum == sum) {
                List<Integer> list = new ArrayList<Integer>(path);
                res.add(list);
            }
        }

        if(current.left!=null){
            dfs(current.left, curSum, path);
        }
        if(current.right!=null){
            dfs(current.right, curSum, path);
        }
        path.remove(path.size() - 1);
    }
}