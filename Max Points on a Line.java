/*
    Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

    Link: https://leetcode.com/problems/max-points-on-a-line/

    Example: None

    Solution: Based on the definition of a line, we can use slope, and a passed point to located a line.
    
    Source: None
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Map<Double, Integer> result = new HashMap<Double, Integer>();
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            int duplicate = 1;
            int vertical = 0;
            for (int j = i + 1; j < points.length; j++) {
                // handle duplicates and vertical
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y) {
                        duplicate++;
                    } else {
                        vertical++;
                    }
                } else {
                    double slope = points[j].y == points[i].y ? 
                        0.0 : (1.0 * (points[j].y - points[i].y)) / (points[j].x - points[i].x);
                    if (result.get(slope) != null) { // if we already have this slope
                        result.put(slope, result.get(slope) + 1);
                    } else {
                        result.put(slope, 1);
                    }
                }
            }
            for (Integer count : result.values()) {
                if (count + duplicate > max) {
                    max = count + duplicate;
                }
            }
            max = Math.max(vertical + duplicate, max);
            result.clear();
        }
        return max;
    }
}