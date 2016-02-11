/*
    Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

    Link: https://leetcode.com/problems/maximal-square/

    Example: For example, given the following matrix:
		1 0 1 0 0
		1 0 1 1 1
		1 1 1 1 1
		1 0 0 1 0
	Return 4.

    Solution: None
    
    Source: None
*/

public class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] size = new int[2][n];
        int max_size = 0;

        for (int j = 0; j < n; ++j) {
            size[0][j] = matrix[0][j] - '0';
            max_size = Math.max(max_size, size[0][j]);
        }
        for (int i = 1; i < m; ++i) {
            size[i % 2][0] = matrix[i][0]  - '0';
            for (int j = 1; j < n; ++j) {
                if (matrix[i][j]  - '0' == 1) {
                    size[i % 2][j] = Math.min(size[i % 2][j - 1], 
                                         Math.min(size[(i - 1) % 2][j], 
                                             size[(i - 1) % 2][j - 1])) + 1;
                    max_size = Math.max(max_size, size[i % 2][j]);
                } else {
                    size[i % 2][j] = 0;
                }
            }
        }
        return max_size * max_size;
    }
}