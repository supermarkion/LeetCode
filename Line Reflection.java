/*
    Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given set of points.

    Link: https://leetcode.com/problemset/algorithms/

    Example: 
        Example 1:
        Given points = [[1,1],[-1,1]], return true.

        Example 2:
        Given points = [[1,1],[-1,-1]], return false.

        Follow up:
        Could you do better than O(n2)?

        Hint:

        Find the smallest and largest x-value for all points.
        If there is a line then it should be at y = (minX + maxX) / 2.
        For each point, make sure that it has a reflected point in the opposite side.

    Solution: None

    Source: https://leetcode.com/discuss/107975/o-1-space-6ms-java-solution
*/

public boolean isReflected(int[][] points) {
    int n = points.length;
    if (n <= 1) {
        return true;
    }
        
    int min = points[0][0];
    int max = points[0][0];
    for (int i = 1; i < n; i++) {
        if (points[i][0] < min) {
            min = points[i][0];
        }
        else if (points[i][0] > max) {
            max = points[i][0]; 
        }   
    }
       
    final int xmax = max;
    final int xmin = min;
    Arrays.sort(points, new Comparator<int[]>() {
        @Override
        public int compare(int[] pa, int[] pb) {
            if (pa[0] != pb[0])
                return pa[0] - pb[0];
            return pa[0] - xmin <= xmax - pa[0] ? pa[1] - pb[1] : pb[1] - pa[1]; // reverse for right side
        }
    });
    for (int i = 0, j = n-1; i <= j; i++, j--) {
        if ((points[i][0] - min != max - points[j][0]) || (points[i][0] * 2 != min + max && points[i][1] != points[j][1])) {
            return false;
        }
    }
        
    return true;
}