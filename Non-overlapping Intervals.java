/*
    Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
    
    Note:
    You may assume the interval's end point is always bigger than its start point.
    Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.

    Link: https://leetcode.com/problems/non-overlapping-intervals/

    Example: 
        Example 1:
        Input: [ [1,2], [2,3], [3,4], [1,3] ]
        Output: 1
        Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.

        Example 2:
        Input: [ [1,2], [1,2], [1,2] ]
        Output: 2
        Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.

        Example 3:
        Input: [ [1,2], [2,3] ]
        Output: 0
        Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

    Solution: None

    Source: https://discuss.leetcode.com/topic/66391/java-concise-code-greedy-method
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length < 1){
            return 0;
        }
        
        Arrays.sort(intervals, ((a, b) -> (a.end - b.end)));
        int sol = 0;
        int firstEnd = intervals[0].start;
        for (Interval interval : intervals) {
            if (firstEnd <= interval.start) {
                firstEnd = interval.end;
            }
            else {
                sol++;
            }
        }
        return sol;
    }
}