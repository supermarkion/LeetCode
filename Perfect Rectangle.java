/*
    Given N axis-aligned rectangles where N > 0, determine if they all together form an exact cover of a rectangular region.

	Each rectangle is represented as a bottom-left point and a top-right point. For example, a unit square is represented as [1,1,2,2]. (coordinate of bottom-left point is (1, 1) and top-right point is (2, 2)).

    Link: https://leetcode.com/problems/perfect-rectangle/

    Example: 
    	Example 1:

			rectangles = [
			  [1,1,3,3],
			  [3,1,4,2],
			  [3,2,4,4],
			  [1,3,2,4],
			  [2,3,3,4]
			]

		Return true. All 5 rectangles together form an exact cover of a rectangular region.

		Example 2:

			rectangles = [
			  [1,1,2,3],
			  [1,3,2,4],
			  [3,1,4,2],
			  [3,2,4,4]
			]

		Return false. Because there is a gap between the two rectangular regions.

		Example 3:

			rectangles = [
			  [1,1,3,3],
			  [3,1,4,2],
			  [1,3,2,4],
			  [3,2,4,4]
			]

		Return false. Because there is a gap in the top center

		Example 4:

			rectangles = [
			  [1,1,3,3],
			  [3,1,4,2],
			  [1,3,2,4],
			  [2,2,4,4]
			]

		Return false. Because two of the rectangles overlap with each other.

    Solution: None

    Source: https://discuss.leetcode.com/topic/56349/o-n-java-solution-with-213-ms-runtime
*/

public class Solution {
    class Point{
        int x;
        int y;
        int index;
        Point (int x, int y, int index){
            this.x = x;
            this.y = y;
            this.index = index;
        }
        
        @Override
        public boolean equals(Object o) {
            if (o instanceof Point) {
                Point b = (Point)o;
                return this.x == b.x && this.y == b.y;
            }
            return false;
        }
        
        @Override 
        public int hashCode() {
            return (new Integer(x).hashCode() + new Integer(y).hashCode());
        }
    }
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length <= 1){
            return true;
        }
        
        int sum = 0;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        HashMap<Point,Integer> hm = new HashMap<>();
        for (int[] rect : rectangles) {
            Point p1 = new Point(rect[0], rect[1], 1);
            Point p2 = new Point(rect[2], rect[3], 2);
            Point p3 = new Point(rect[0], rect[3], 3);
            Point p4 = new Point(rect[2], rect[1], 4);
            sum += (rect[2] - rect[0]) * (rect[3] - rect[1]);
            
            minX = Math.min(minX,rect[0]);
            minY = Math.min(minY,rect[1]);
            
            maxX = Math.max(maxX,rect[2]);
            maxY = Math.max(maxY,rect[3]);
            
            Point[] points = {p1, p2, p3, p4};
            for (Point p : points) {
                if (hm.containsKey(p) && hm.get(p) != p.index) {
                    hm.remove(p);
                } else {
                    hm.put(p, p.index);
                }
            }
        }
        return (hm.size() == 4) && (sum == (maxX - minX) * (maxY - minY));
    }
}