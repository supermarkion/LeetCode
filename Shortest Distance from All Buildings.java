/*
    You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, 
    down, left and right. You are given a 2D grid of values 0, 1 or 2, where:
		Each 0 marks an empty land which you can pass by freely.
		Each 1 marks a building which you cannot pass through.
		Each 2 marks an obstacle which you cannot pass through.

    Link: https://leetcode.com/problemset/algorithms/

    Example: 
	    For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):
			1 - 0 - 2 - 0 - 1
			|   |   |   |   |
			0 - 0 - 0 - 0 - 0
			|   |   |   |   |
			0 - 0 - 1 - 0 - 0
		The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
	
    Solution: None

    Source: http://buttercola.blogspot.com.au/2016/01/leetcode-shortest-distance-from-all.html
*/

public class Solution {
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int m = grid.length;
        int n = grid[0].length;
         
        int[][] dist = new int[m][n];
        int[][] reach = new int[m][n];
        // step 1: BFS and calcualte the min dist from each building
        int numBuildings = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[m][n];
                    Queue<Integer> queue = new LinkedList<>();
                    shortestDistanceHelper(i, j, 0, dist, reach, grid, visited, queue);
                    numBuildings++;
                }
            }
        }
         
        // step 2: caluclate the minimum distance
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == numBuildings) {
                    minDist = Math.min(minDist, dist[i][j]);
                }
            }
        }
         
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
     
    private void shortestDistanceHelper(int x, int y, int currDist, 
                                        int[][] dist, int[][] reach, int[][] grid,
                                        boolean[][] visited, Queue<Integer> queue) {
        fill(x, y, x, y, currDist, dist, reach, grid, visited, queue);
         
        int m = grid.length;
        int n = grid[0].length;
         
        while (!queue.isEmpty()) {
            int size = queue.size();
            currDist++;
            for (int sz = 0; sz < size; sz++) {
                int cord = queue.poll();
                int i = cord / n;
                int j = cord % n;
                 
                fill(x, y, i - 1, j, currDist, dist, reach, grid, visited, queue);
                fill(x, y, i + 1, j, currDist, dist, reach, grid, visited, queue);
                fill(x, y, i, j - 1, currDist, dist, reach, grid, visited, queue);
                fill(x, y, i, j + 1, currDist, dist, reach, grid, visited, queue);
            }
 
        }
    }
     
    private void fill(int origX, int origY, int x, int y, int currDist, 
                      int[][] dist, int[][] reach,  
                      int[][] grid, boolean[][] visited, Queue<Integer> queue) {
         
        int m = dist.length;
        int n = dist[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
            return;
        }
         
        if ((x != origX || y != origY) && grid[x][y] != 0) {
            return;
        }
         
        visited[x][y] = true;
         
        dist[x][y] += currDist;
        reach[x][y]++;
         
        queue.offer(x * n + y);
    }
}