/*
    Given a collection of intervals, merge all overlapping intervals.
    
    Link: https://leetcode.com/problems/merge-intervals/

    Example: For example,
		Given [1,3],[2,6],[8,10],[15,18],
		return [1,6],[8,10],[15,18].

    Solution: Typical sort by container, and loop array.
    
    Source: None
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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        Collections.sort(intervals, new IntervalComparator());       
        ArrayList<Interval> result = new ArrayList<Interval>();
        Interval last = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval curt = intervals.get(i);
            if (curt.start <= last.end ){
                last.end = Math.max(last.end, curt.end);
            }else{
                result.add(last);
                last = curt;
            }
        }
        result.add(last);
        return result;
    }
    
    private class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}