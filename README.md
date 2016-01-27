# LeetCode
Save Codes on LeetCode questions implmement

1. When we want to sort list with objects, we use a class to define comparator.
for example:
	Collections.sort(intervals, new IntervalComparator());

private class IntervalCompareator implements Comparator<Interval> {
	public int compare(Interval a, Interval b) {
	    return a.start - b.start;
    }
}
2. The Text Justification.java is a template on construct text file with special format.



