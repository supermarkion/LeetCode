/*
    The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
    Given an integer n, return all distinct solutions to the n-queens puzzle. Each solution contains a distinct board 
    configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
    
    Link: https://leetcode.com/problems/n-queens/

    Example: There exist two distinct solutions to the 4-queens puzzle:
		[
		 [".Q..",  // Solution 1
		  "...Q",
		  "Q...",
		  "..Q."],

		 ["..Q.",  // Solution 2
		  "Q...",
		  "...Q",
		  ".Q.."]
		]

    Solution: The main point is that n is greater than 0 or less.
    
    Source: None
*/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        int[] placement = new int[n];
        NQueensHelper(n, 0, placement, result);
        return result;
    }
    
    private void NQueensHelper(int n, int row, int[] placement, List<List<String>> result) {
        if (row == n) {
            result.add(CreateOutput(placement));
        } else {
            for (int col = 0; col < n; col++) {
                placement[row] = col;
                if (isFeasible(placement, row)) {
                    NQueensHelper(n, row + 1, placement, result);
                }
            }
        }
    }
    
    private List<String> CreateOutput(int[] placement) {
        List<String> sol = new ArrayList<String>();
        for (int row : placement) {
            char[] line = new char[placement.length];
            Arrays.fill(line, '.');
            line[row] = 'Q';
            sol.add(String.valueOf(line));
        }
        return sol;
    }
    
    private boolean isFeasible(int[] placement, int row) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(placement[i] - placement[row]);
            if (diff == 0 || diff == row - i) {
                return false;
            }
        }
        return true;
    }
}