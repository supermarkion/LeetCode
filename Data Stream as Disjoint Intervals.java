/*
    Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

    Link: https://leetcode.com/problems/data-stream-as-disjoint-intervals/

    Example:  
        For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
		[1, 1]
		[1, 1], [3, 3]
		[1, 1], [3, 3], [7, 7]
		[1, 3], [7, 7]
		[1, 3], [6, 7]
    
    Solution: None

    Source: http://bookshadow.com/weblog/2016/05/31/leetcode-data-stream-as-disjoint-intervals/
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
public class SummaryRanges {

    /** Initialize your data structure here. */
    
    private TreeSet<Interval> intervalSet; 
    
    public SummaryRanges() {
        intervalSet = new TreeSet<Interval>(new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
    }
    
    public void addNum(int val) {
        Interval valInterval = new Interval(val, val);
        Interval floor = intervalSet.floor(valInterval);
        if (floor != null) {
            if (floor.end >= val) {
                return;
            } else if (floor.end + 1 == val) {
                valInterval.start = floor.start;
                intervalSet.remove(floor);
            }
        }
        Interval higher = intervalSet.higher(valInterval);
        if (higher != null && higher.start == val + 1) {
            valInterval.end = higher.end;
            intervalSet.remove(higher);
        }
        intervalSet.add(valInterval);
    }
    
    public List<Interval> getIntervals() {
        return Arrays.asList(intervalSet.toArray(new Interval[0]));
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */