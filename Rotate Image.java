/*
    You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
    
    Link: https://leetcode.com/problems/rotate-image/

    Example: None

    Solution: Rotate by anti-diagonal firstly, then rotate by x-axis (middle x-axis);
    
    Source: None
*/

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // anti-diagonal mirror
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }
        // horizontal mirror
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - 1 - i, j);
            }
        }
    }
    private void swap(int[][] matrix, int a, int b, int c, int d) {
        int temp = matrix[a][b];
        matrix[a][b] = matrix[c][d];
        matrix[c][d] = temp;
    }
}