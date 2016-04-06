/*
    None
    
    Link: https://leetcode.com/problemset/algorithms/

    Example: None
	
    Solution: None

    Source: https://leetcode.com/discuss/96033/java-dfs-based-7ms-solution
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
        if(NIL == null){
            return;
        }
        for(NestedInteger NI : NIL){
            if(NI.isInteger()){
                flattenedList.add(NI.getInteger());
            }
            else{
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
