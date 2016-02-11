/*
    Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

    Link: https://leetcode.com/problems/valid-sudoku/

    Example: None

    Solution: n this problem, in order to speed up the process on calculate the number in char matrix
	is unique, we use the char minus ’1’ to get the distance in ASCII code, and use it as index of a list, then if
	it already exits this number, it boolean result should be true, and then return false
    
    Source: None
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
        	return false;
        }
    		
    	// check each column
    	for (int i = 0; i < 9; i++) {
    		boolean[] m = new boolean[9];
    		for (int j = 0; j < 9; j++) {
    			if (board[i][j] != '.') {
    				if (m[(int) (board[i][j] - '1')]) {
    					return false;
    				}
    				m[(int) (board[i][j] - '1')] = true;
    			}
    		}
    	}
     
    	//check each row
    	for (int j = 0; j < 9; j++) {
    		boolean[] m = new boolean[9];
    		for (int i = 0; i < 9; i++) {
    			if (board[i][j] != '.') {
    				if (m[(int) (board[i][j] - '1')]) {
    					return false;
    				}
    				m[(int) (board[i][j] - '1')] = true;
    			}
    		}
    	}
     
    	//check each 3*3 matrix
    	for (int block = 0; block < 9; block++) {
    		boolean[] m = new boolean[9];
    		for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
    			for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
    				if (board[i][j] != '.') {
    					if (m[(int) (board[i][j] - '1')]) {
    						return false;
    					}
    					m[(int) (board[i][j] - '1')] = true;
    				}
    			}
    		}
    	}
     
    	return true;
    }
}