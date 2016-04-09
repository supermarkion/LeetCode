 /*
    An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. The black pixels are connected, 
    i.e., there is only one black region. Pixels are connected horizontally and vertically. Given the location (x, y) of one 
    of the black pixels, return the area of the smallest (axis-aligned) rectangle that encloses all black pixels.
    
    Link: https://leetcode.com/problemset/algorithms/

    Example: 
		For example, given the following image:
			[
			  "0010",
			  "0110",
			  "0100"
			]
			and x = 0, y = 2,
		return 6
	
    Solution: None

    Source: http://www.cnblogs.com/yrbbest/p/5050022.html
*/

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        if (image == null || image.length == 0) {
            return 0;
        }
        int rowNum = image.length, colNum = image[0].length;
        int left = binarySearch(image, 0, y, 0, rowNum, true, true);
        int right = binarySearch(image, y + 1, colNum, 0, rowNum, true, false);
        int top = binarySearch(image, 0, x, left, right, false, true);
        int bot = binarySearch(image, x + 1, rowNum, left, right, false, false);
        
        return (right - left) * (bot - top);
    }
    
    private int binarySearch(char[][] image, int lo, int hi, int min, int max, boolean searchHorizontal, boolean searchLo) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            boolean hasBlackPixel = false;
            for (int i = min; i < max; i++) {
                if((searchHorizontal ? image[i][mid] : image[mid][i]) == '1') {
                    hasBlackPixel = true;
                    break;
                }
            }
            if (hasBlackPixel == searchLo) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}