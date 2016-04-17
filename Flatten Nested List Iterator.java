/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> nL;
    private int currentCount;
    private int totalCount;
    private List<Integer> flattenedList;

    public NestedIterator(List<NestedInteger> nestedList) {
           this.nL = nestedList;
           currentCount = 0;
           flattenedList = new ArrayList<Integer>();
           doListFlat(nestedList);
           totalCount = flattenedList.size();
    }

    private void doListFlat(List<NestedInteger> NIL){
        if (NIL == null) {
            return;
        }
        for (NestedInteger NI : NIL) {
            if (NI.isInteger()) {
                flattenedList.add(NI.getInteger());
            } else {
                doListFlat(NI.getList());
            }
        }
        return;
    }

    @Override
    public Integer next() {
            int ret = flattenedList.get(currentCount);
            currentCount += 1;
            return ret;
    }

    @Override
    public boolean hasNext() {
        return currentCount < totalCount;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */