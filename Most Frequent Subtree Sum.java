/*
	Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined 
	as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is 
	the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.

    Link: https://leetcode.com/problems/most-frequent-subtree-sum/

	Example: 
	
		Examples 1
			Input:
			  5
			 /  \
			2   -3
			return [2, -3, 4], since all the values happen only once, return all of them in any order.

		Examples 2
			Input:
			  5
			 /  \
			2   -5
			return [2], since 2 happens twice, however -5 only occur once.
		
    Solution: None

    Source: https://discuss.leetcode.com/topic/77766/short-easy-java
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
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
        	return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);
        List<Integer> res = new LinkedList<>();
        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            if (me.getValue() == max) {
				res.add(me.getKey());
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    private int helper(TreeNode n, Map<Integer, Integer> map){
        int left = (n.left == null) ? 0 : helper(n.left, map);
        int right = (n.right == null) ? 0 : helper(n.right, map);
        int sum = left + right + n.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));
        return sum;
    }
}