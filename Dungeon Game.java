/*
    The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N 
    rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through 
    the dungeon to rescue the princess.

	The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, 
	he dies immediately.

	Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms 
	are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

	In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

    Link: https://leetcode.com/problems/dungeon-game/

    Example: For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal 
    path RIGHT-> RIGHT -> DOWN -> DOWN.

    Solution: None
    
    Source: None
*/

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null) {
            return 0;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = 1;
        for (int i = row - 2; i > -1; i--) {
            dp[i][col - 1] = Math.max(1, dp[i + 1][col - 1] - dungeon[i + 1][col - 1]);
        }
        for (int i = col - 2; i > -1; i--) {
            dp[row - 1][i] = Math.max(1, dp[row - 1][i + 1] - dungeon[row - 1][i + 1]);
        }
        for (int i = row - 2; i > -1; i--) {
            for (int j = col - 2; j > -1; j --) {
                int right = Math.max(1, dp[i][j + 1] - dungeon[i][j + 1]);
                int down = Math.max(1, dp[i + 1][j] - dungeon[i + 1][j]);
                dp[i][j] = Math.min(right, down);
            }
        }
        return Math.max(1, dp[0][0] - dungeon[0][0]);
    }
}