/*
    Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?

    Link: https://leetcode.com/problems/h-index-ii/

    Example: None

    Solution: None
    
    Source: https://leetcode.com/discuss/63454/simple-13ms-java-solution
*/

public class Solution {
    public int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length - 1;
        int len = citations.length;
        int result = 0;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (citations[mid] >= (len - mid)) {
                result = (len - mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}