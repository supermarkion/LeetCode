/*
    Follow up for N-Queens problem. Now, instead outputting board configurations, return the total number of distinct solutions.
    
    Link: https://leetcode.com/problems/n-queens-ii/

    Example: None

    Solution: When we are asked to get the number of available solutions to the N-queens problems based no given number, we 
    just construct a global variable, and use it to update and get solution number.
    
    Source: None
*/

public class Solution {
    int res;
    public int totalNQueens(int n) {
        res = 0;
        if (n <= 0) {
            return res;
        }
        int[] columnVal = new int[n];
        DFS_helper(n, 0, columnVal);
        return res;
    }
    
    private void DFS_helper(int nQueens, int row, int[] columnVal) {
        if (row == nQueens) {
            res += 1;
        } else {
            for (int i = 0; i < nQueens; i++) {
                columnVal[row] = i;
                if (isValid(row, columnVal)) {
                    DFS_helper(nQueens, row + 1, columnVal);
                }
            }
        }
    }
    
    private boolean isValid(int row, int[] columnVal) {
        for (int i = 0; i < row; i++) {
            if (columnVal[row] == columnVal[i] || Math.abs(columnVal[row] - columnVal[i]) == row - i) {
                return false;
            }
        }
        return true;
    }
}