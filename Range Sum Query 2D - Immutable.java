/*
    Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner 
    (row1, col1) and lower right corner (row2, col2).

    Link: https://leetcode.com/problems/range-sum-query-2d-immutable/

    Example: 
    	Given matrix = [
		  [3, 0, 1, 4, 2],
		  [5, 6, 3, 2, 1],
		  [1, 2, 0, 1, 5],
		  [4, 1, 0, 1, 7],
		  [1, 0, 3, 0, 5]
		]

	sumRegion(2, 1, 4, 3) -> 8
	sumRegion(1, 1, 2, 2) -> 11
	sumRegion(1, 2, 2, 4) -> 12

    Solution: Similar approach to solve Range Sum Query.
		    
    Source: https://leetcode.com/discuss/78918/java-easy-version-to-understand
*/

public class NumMatrix {
    
    int[][] matrix;
    int[][] dp;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
        	return;
        }
        this.matrix = matrix;
        int rows = matrix.length, colunms = matrix[0].length, sum = 0;
        dp = new int[rows][colunms];
    
        for (int i = 0; i < rows; i++) {
            dp[i][0] = sum + matrix[i][0];
            sum = sum + matrix[i][0];
        }
        sum = matrix[0][0];
        for (int i = 1; i < colunms; i++) {
            dp[0][i] = sum + matrix[0][i];
            sum = sum + matrix[0][i];
        }
    
        for (int i = 1; i < rows; i++) {
        	for (int j = 1; j < colunms; j++) {
        		dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + matrix[i][j];
        	}
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 == 0 && col1 == 0) {
        	return dp[row2][col2];
        } else if (row1 == 0) {
        	return dp[row2][col2] - dp[row2][col1 - 1];
        } else if (col1 == 0) {
        	return dp[row2][col2] - dp[row1 - 1][col2];
        } else if (row1 >= 1 && col1 >= 1) {
        	return dp[row2][col2] - dp[row2][col1 - 1] - dp[row1 - 1][col2] + dp[row1 - 1][col1 - 1];
        }        
        return 0;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);