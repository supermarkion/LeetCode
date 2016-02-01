/*
    Given an integer matrix, find the length of the longest increasing path. From each cell, you can either move to four directions: 
    left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

    Link: https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

    Example: 
        Example 1:

        nums = [
          [9,9,4],
          [6,6,8],
          [2,1,1]
        ]
        Return 4
        The longest increasing path is [1, 2, 6, 9].

        Example 2:

        nums = [
          [3,4,5],
          [3,2,6],
          [2,2,1]
        ]
        Return 4
        The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

    Solution: None
            
    Source: https://leetcode.com/discuss/83142/java-easy-version-to-understand
*/

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return 0;

        int max = 0, n = matrix.length, m = matrix[0].length;

        // create a cache matrix
        int[][] cache = new int[n][m];

        // dfs search on every element in matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(dfs(matrix, Integer.MIN_VALUE, i, j, n, m, cache), max);
            }
        }
        return max;
    }

    int dfs(int[][] matrix, int min, int i, int j, int n, int m, int[][] cache) {

        // check boundary limits
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 0;

        // check min condition
        if (matrix[i][j] <= min)
            return 0;

        // check into cache
        if (cache[i][j] != 0)
            return cache[i][j];

        // update min
        min = matrix[i][j];

        // run dfs in all four directions
        int a = dfs(matrix, min, i - 1, j, n, m, cache) + 1;
        int b = dfs(matrix, min, i + 1, j, n, m, cache) + 1;
        int c = dfs(matrix, min, i, j - 1, n, m, cache) + 1;
        int d = dfs(matrix, min, i, j + 1, n, m, cache) + 1;

        // find max and update cache
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;

        return max;
    }
}