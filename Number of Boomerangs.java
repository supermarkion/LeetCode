/*
    Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that 
    the distance between i and j equals the distance between i and k (the order of the tuple matters).

    Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the 
    range [-10000, 10000] (inclusive).
    
    Link: https://leetcode.com/problems/number-of-boomerangs/

    Example: 
        Input:
        [[0,0],[1,0],[2,0]]

        Output:
        2

        Explanation:
        The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

    Solution: None

    Source: https://discuss.leetcode.com/topic/67385/java-o-n-2-solution
*/

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int num = 0;
        for (int i = 0; i< points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j == i) {
                    continue;
                }
                    
                int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                map.putIfAbsent(distance, 0);
                map.put(distance, map.get(distance) + 1);
            }
            for (int n : map.values()) {
                num += n * (n - 1);
            }
                
        }
        return num;
    }
}