/*
    Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.'.
    
    Link: https://leetcode.com/problems/sudoku-solver/

    Example: None

    Solution: None
    
    Source: https://leetcode.com/discuss/76284/java-solution-using-backtracking-beats-99-70%25
*/

public class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] status = new boolean[3*9][10];
        int index;
    
        for(int i = 0; i < 9; i++){//record the board status
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                index = board[i][j] - '0';
                status[i][index] = true;
                status[9 + j][index] = true;
                status[2 * 9 + i / 3 * 3 + j / 3][index] = true;
            }
        }
        helper(0, 0, status, board);
    }
    
    private boolean helper(int i, int j, boolean[][] status, char[][] board){
        if(j >= 9){
            i++;
            if(i >= 9){
                return true;
            }
            j = 0;
        }
        if(board[i][j] == '.'){
            int m;
            for(m = 1; m <= 9; m++){
                if(status[i][m] || status[9 + j][m] || status[2 * 9 + i / 3 * 3 + j / 3][m]){// check which number to put
                    continue;
                }else{
                    board[i][j] = (char)(m + '0');
                    status[i][m] = status[9 + j][m] = status[2 * 9 + i / 3 * 3 + j / 3][m] = true;
                    if(!helper(i, j + 1, status, board)){// reverse the changes
                        board[i][j] = '.';
                        status[i][m] = status[9 + j][m] = status[2 * 9 + i / 3 * 3 + j / 3][m] = false;
                    }else{
                        return true;
                    }
                }
            }
            if(m > 9){
                return false;
            }else{
                return true;
            }
        }else{
            return helper(i, j + 1, status, board);
        }
    }
}