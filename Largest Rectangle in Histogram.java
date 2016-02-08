/*
    Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area 
    of largest rectangle in the histogram.

    Link: https://leetcode.com/problems/largest-rectangle-in-histogram/

    Example: For example, Given heights = [2,1,5,6,2,3], return 10.

    Solution: The main point is that we should know that when we face the new less area, we should compute the current
    maximum area of rectangle in histogram.
    
    Source: None
*/

public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int p = stack.pop();
                int h = heights[p];
                // consider of that we pop one, then we add 1 to the width
                int w = stack.isEmpty() ? i : i - (stack.peek() + 1);
                max = Math.max(max, w * h);
            }
        }
        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = heights[p];
            int w = stack.isEmpty() ? i : i - (stack.peek() + 1);
            max = Math.max(max, w * h);
        }
        return max;
    }
}