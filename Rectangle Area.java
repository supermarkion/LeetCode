/*
    Find the total area covered by two rectilinear rectangles in a 2D plane. Each rectangle is defined 
    by its bottom left corner and top right corner as shown in the figure.
    
    Link: https://leetcode.com/problems/rectangle-area/

    Example: None

    Solution: None
    
    Source: https://leetcode.com/discuss/79214/easy-understanding-concise-java-solution
*/

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a = (C - A) * (D - B), b = (G - E) * (H - F);
        return a + b - overlap(A, C, E, G) * overlap(F, H, B, D);
    }

    private int overlap(int a, int b, int c, int d) {
        if (b <= c || d <= a) { 
        	return 0; 
        }  // not overlapping
        return Math.min(b, d) - Math.max(a, c);
    }
}