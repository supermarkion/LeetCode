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
3. From now on, I should use Thinking in Java to practice my OOP defintions.
4. When you say something is static, it means that particular field or method is not tied to any particular object instance of that class.
5. However, for the static nested classes, you should use final to declare you class, prevents extension of the class since extending a static class makes no sense. After that, make the constructor to private, and use static to declare all methods.
6. The good of static classes is that it can define one-off, utility and library classes where instatiation would not make sense.










