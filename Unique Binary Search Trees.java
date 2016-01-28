/*
    Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

    Link: https://leetcode.com/problems/unique-binary-search-trees/

    Example: For example,
		Given n = 3, there are a total of 5 unique BST's.

		   1         3     3      2      1
		    \       /     /      / \      \
		     3     2     1      1   3      2
		    /     /       \                 \
		   2     1         2                 3

    Solution: None

    Source: None
*/

public class Solution {
    public int numTrees(int n) {
        if (n < 0) {
            return -1;
        }
        int[] count = new int[n + 1];
        count[0] = 1;
        for (int i = 1; i < n + 1; ++i) {
            for (int j = 0; j < i; ++j) {
                count[i] += count[j] * count[i - j - 1];
            }
        }
        return count[n];
    }
}