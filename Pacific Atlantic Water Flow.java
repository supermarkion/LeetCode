/*
    Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, 
    the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
    
    Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
    
    Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

    Note:
        The order of returned grid coordinates does not matter.
        Both m and n are less than 150.

    Note:
        Assume the length of given string will not exceed 1,010.

    Link: https://leetcode.com/problems/pacific-atlantic-water-flow/

    Example: 
        
        Given the following 5x5 matrix:

          Pacific ~   ~   ~   ~   ~ 
               ~  1   2   2   3  (5) *
               ~  3   2   3  (4) (4) *
               ~  2   4  (5)  3   1  *
               ~ (6) (7)  1   4   5  *
               ~ (5)  1   1   2   4  *
                  *   *   *   *   * Atlantic

        Return:

        [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

    Solution: None

    Source: https://discuss.leetcode.com/topic/62694/java-clean-simple-dfs-solution
*/

public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        
        List<int[]> result = new ArrayList<int[]>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null ) {
          return result;
        }
            
        int row = matrix.length;
        int col = matrix[0].length;
        
        Set<Integer> pacific = new HashSet<Integer>();
        Set<Integer> atlantic = new HashSet<Integer>();
        
        for (int i = 0; i < col; ++i) {
            DFSHelper(i, pacific, matrix);
            DFSHelper((row - 1) * matrix[0].length + i, atlantic, matrix);
        }
        for (int i = 0; i < row; ++i) {
            DFSHelper(i * matrix[0].length, pacific, matrix);
            DFSHelper(i * matrix[0].length + col - 1, atlantic, matrix);
        }    
        for (int pos : pacific) {
            if (atlantic.contains(pos)) {
                int i = pos / matrix[0].length;
                int j = pos % matrix[0].length;
                int[] tmpResult = {i, j};
                result.add(tmpResult);
            }
        }
        return result;
    }
    
    public void DFSHelper(int pos, Set<Integer> result, int[][] matrix) {
        
        if (result.contains(pos)) {
          return;
        }
        int i = pos / matrix[0].length;
        int j = pos % matrix[0].length;
        result.add(pos);
        int[][] directions = {{0 , -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int[] direction: directions) {
            int di = i + direction[0];
            int dj = j + direction[1];
            if (di >= 0 && di < matrix.length && dj >= 0 && dj < matrix[0].length && matrix[di][dj] >= matrix[i][j]) {
                DFSHelper(di * matrix[0].length + dj, result, matrix);
            }
        }
    }  
}