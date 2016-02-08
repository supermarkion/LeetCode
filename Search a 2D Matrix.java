/*
    Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
		Integers in each row are sorted from left to right.
		The first integer of each row is greater than the last integer of the previous row.

    Link: https://leetcode.com/problems/search-a-2d-matrix/

    Example: Consider the following matrix:
		[
		  [1,   3,  5,  7],
		  [10, 11, 16, 20],
		  [23, 30, 34, 50]
		]
		Given target = 3, return true.

    Solution: In this problem, we should use a pointer to move through matrix based its definition. However, we should
    also consider of situation that not stuck in first line, not raise error at edge.
    
    Source: None
*/

 public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = 0;
        while (col < matrix[row].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                row++;
                break;
            }
        }
        if (col == matrix[0].length) {
            col--;
        }
        while (row < matrix.length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                row++;
            }
            if (col == matrix[0].length) {
                row++;
                col--;
            } else if (col == -1) {
                row++;
                col++;
            }
        }
        return false;
    }
}