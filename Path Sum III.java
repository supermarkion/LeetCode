/*
    You are given a binary tree in which each node contains an integer value.

    Find the number of paths that sum to a given value.

    The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

    The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

    Link: https://leetcode.com/problems/path-sum-iii/

    Example: 
        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

              10
             /  \
            5   -3
           / \    \
          3   2   11
         / \   \
        3  -2   1

        Return 3. The paths that sum to 8 are:

        1.  5 -> 3
        2.  5 -> 2 -> 1
        3. -3 -> 11

    Solution: None

    Source: https://discuss.leetcode.com/topic/65261/19-ms-java-solution-with-dfs-prefixsum-time-o-n-space-o-depth-of-tree
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
    public int pathSum(TreeNode root, int sum) {
    Map<Integer, Integer> prefixSum = new HashMap<>();
    prefixSum.put(0,1);
    return dfs(root, sum, 0, prefixSum);
    }
  private int dfs(TreeNode root, int sum, int curSum, Map<Integer, Integer> prefixSum) {
    if (root == null) {
      return 0;
    }
    curSum += root.val;
    int result = 0;
    if (prefixSum.containsKey(curSum - sum)) {
      result = prefixSum.get(curSum - sum);
    }
    int count = prefixSum.getOrDefault(curSum, 0);
    prefixSum.put(curSum, count + 1);
    result += dfs(root.left, sum, curSum, prefixSum);
    result += dfs(root.right, sum, curSum, prefixSum);
    if (count == 0) {
        prefixSum.remove(curSum);
    } else {
        prefixSum.put(curSum, count);
    }
    return result;
  }
}