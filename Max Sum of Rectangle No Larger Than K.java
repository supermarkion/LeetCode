/*
    Given a non-empty 2D matrix matrix and an integer k, find the max sum of a rectangle in the matrix such that its sum is no larger than k.

    Link: https://leetcode.com/problems/max-sum-of-sub-matrix-no-larger-than-k/

    Example: 
		Given matrix = [
		  [1,  0, 1],
		  [0, -2, 3]
		]
		k = 2
		The answer is 2. Because the sum of rectangle [[0, 1], [-2, 3]] is 2 and 2 is the max number no larger than k (k = 2).
    
    Solution: None

    Source: https://leetcode.com/discuss/110363/java-244ms-applying
*/

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
    //Assuming that rows is larger than the number of cols

    int row = matrix.length, col = matrix[0].length;
    int minDf = Integer.MAX_VALUE;
    for (int left = 0; left < col; left++) {
        int[] tmp = new int[row];
        for (int right = left; right < col; right++) {
            TreeSet<Integer> set = new TreeSet<>();
            int cursum = 0;
            for (int i = 0; i < row; i++) {
                tmp[i] += matrix[i][right];
                cursum += tmp[i];
                if (cursum == k) {
                	return k;
                }
                if (cursum < k) {
                	minDf = Math.min(minDf, k - cursum);
                } 
                Integer x = set.ceiling(cursum - k);
                if (x != null && cursum - x <= k) {
                	minDf = Math.min(minDf, k - cursum + x);
                }
                if (minDf == 0) {
                	return k;
                }
                set.add(cursum);
            }
        }
    }
    return k - minDf;
    }
}