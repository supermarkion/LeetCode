/*
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    
    Link: https://leetcode.com/problems/spiral-matrix/

    Example: Given the following matrix:
		[
		 [ 1, 2, 3 ],
		 [ 4, 5, 6 ],
		 [ 7, 8, 9 ]
		]
		You should return [1,2,3,6,9,8,7,4,5].

    Solution: Around the 'cycle' to construct this matrix, but take the reverse order of problem two.
    
    Source: None
*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0) {
            return res;
        }
        // construct a large 'cycle'
        for (int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
            left <= right && top <= bottom; left++, right--, top++, bottom--) {
            // left to right (at first row)
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            // top to bottom (at right column)
            for (int i = top + 1; i < bottom; i++) {
                res.add(matrix[i][right]);
            }
            // right to left (at bottom row)
            for (int j = right; top < bottom && j >= left; j--) {
                res.add(matrix[bottom][j]);
            }
            // bottom to top (at left column)
            for (int i = bottom - 1; left < right && i > top; i--) {
                res.add(matrix[i][left]);
            }
        }
        
        return res;
    }
}