/*
    Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

    Link: https://leetcode.com/problems/triangle/

    Example: For example, given the following triangle
		[
		     [2],
		    [3,4],
		   [6,5,7],
		  [4,1,8,3]
		]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

    Solution: We traversal the triangle from bottom to top, and make the value which located at index i and j only decided by 
    the sum of values in i + 1, j and i + 1, j + 1.
    
    Source: None
*/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int value = Math.min(triangle.get(i + 1).get(j) + triangle.get(i).get(j),
                                        triangle.get(i + 1).get(j + 1) + triangle.get(i).get(j));
                triangle.get(i).set(j, value);
            }
        }
        return triangle.get(0).get(0);
    }
}