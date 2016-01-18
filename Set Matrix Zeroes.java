/*
    Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

    Link: https://leetcode.com/problems/set-matrix-zeroes/

    Example: None

    Solution: Use a flag to control whole process, and speed up computation.

    Source: None
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean has_zero = false;
        int zero_i = -1;
        int zero_j = -1;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (!has_zero) {
                        zero_i = i;
                        zero_j = j;
                        has_zero = true;
                    }
                    matrix[zero_i][j] = 0;
                    matrix[i][zero_j] = 0;
                }
            }
        }
        
        if (has_zero) {
            for (int i = 0; i < matrix.length; i++) {
                if (i == zero_i) {
                    continue;
                }
                for (int j = 0; j < matrix[i].length; j++) {
                    if (j == zero_j) {
                        continue;
                    }
                    if (matrix[zero_i][j] == 0 || matrix[i][zero_j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][zero_j] = 0;
            }
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[zero_i][j] = 0;
            }
        }
    }
}