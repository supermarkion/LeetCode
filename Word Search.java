/*
    Given a 2D board and a word, find if the word exists in the grid. The word can be constructed from letters of sequentially 
    adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used 
    more than once.

    Link: https://leetcode.com/problems/word-search/

    Example: 
    	Given board =
		[
		  ['A','B','C','E'],
		  ['S','F','C','S'],
		  ['A','D','E','E']
		]
		word = "ABCCED", -> returns true,
		word = "SEE", -> returns true,
		word = "ABCB", -> returns false.

    Solution: In this method, we search the word based on given dict. In order to finish this task, we maintain a visited
    matrix to perform dfs search. In order to achieve the goal, we should use recursion to test result.
    
    Source: None
*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, boolean[][] visited, int row, int column, int wi) {
        if (row < 0 || row > board.length - 1 || column < 0 || column > board[0].length - 1) {
            return false;
        }
        if (!visited[row][column] && board[row][column] == word.charAt(wi)) {
            if (wi == word.length() - 1) {  // if we match last char of target word
                return true;
            }
            visited[row][column] = true;
            boolean down = dfs(board, word, visited, row + 1, column, wi + 1);
            boolean up = dfs(board, word, visited, row - 1, column, wi + 1);
            boolean left = dfs(board, word, visited, row, column - 1, wi + 1);
            boolean right = dfs(board, word, visited, row, column + 1, wi + 1);
            
            // reset with false if none of above is true, which mean if there is no char around current meet
            // our word, we are fail on searching
            visited[row][column] = up || down || left || right;
            return up || down || left || right;
        }
        return false;
    }
}