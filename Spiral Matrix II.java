/*
    Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
    
    Link: https://leetcode.com/problems/spiral-matrix-ii/

    Example: 
	    Given n = 3, you should return the following matrix:
		[
		 [ 1, 2, 3 ],
		 [ 8, 9, 4 ],
		 [ 7, 6, 5 ]
		]

    Solution: None
    
    Source: https://leetcode.com/discuss/72905/my-java-solution-which-is-easy-understand
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        if (n < 0) {
            n = -n;
        }
            
        int[][] res = new int[n][n];
        int count = 1;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = i; j < n - i; j++) {
                res[i][j] = count;
                count++;
            }
            for (int k = i + 1; k < n - i; k++) {
                res[k][n - 1 - i] = count;
                count++;
            }
            for (int l = n - 2 - i; l >= i; l--) {
                res[n - 1 - i][l] = count;
                count++;
            }
            for (int m = n - 2 - i; m >= i + 1; m--) {
                res[m][i] = count;
                count++;
            }
            if (count > n * n)
                break;
        }
        return res;
    }
}