/*
    Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

    Link: https://leetcode.com/problems/maximal-rectangle/

    Example: None

    Solution: The main point is that we assign the dp matrix with the minimum of surrounding values.
    
    Source: https://leetcode.com/discuss/84256/o-n-2-dp-java-solution
*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        } 
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n]; // left boundary of histogram columns.
        int[] right = new int[n]; // right boundary of histogram columns.
        int[] height = new int[n]; // height of histogram columns.
        Arrays.fill(right, n);
        int area = 0;
        for (int i = 0; i < m; i++) {
            int l = 0, r = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(l, left[j]);
                }
                else {
                    l = j + 1;
                    height[j] = 0;
                    left[j] = 0;
                    right[j] = n;
                }
            }
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(r, right[j]);
                    area = Math.max(area, height[j] * (right[j] - left[j]));
                }
                else {
                    r = j;
                }
            }
        }
        return area;
    }
}