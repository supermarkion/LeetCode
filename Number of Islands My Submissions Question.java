/*
    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is 
    formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded 
    by water.
    
    Link: https://leetcode.com/problems/number-of-islands/

    Example: 
    	Example 1:
		11110
		11010
		11000
		00000
		Answer: 1

		Example 2:
		11000
		11000
		00100
		00011
		Answer: 3

    Solution: This problem requires us to search to next locations of each pixel, and find the final solution.
    
    Source: None
*/

public class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    private int n, m;
    
    private void removeIsland(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (grid[nextX][nextY] == '1') {
                    removeIsland(grid, nextX, nextY);
                }
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        n = grid.length;
        if (n == 0) {
            return 0;
        }
        
        m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    removeIsland(grid, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
}