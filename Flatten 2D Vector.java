/*
    Implement an iterator to flatten a 2d vector.

    Link: https://leetcode.com/problemset/algorithms/

    Example:  
        For example,
		Given 2d vector =
			[
			  [1,2],
			  [3],
			  [4,5,6]
			]
		By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
    
    Solution: None

    Source: http://blog.csdn.net/pointbreak1/article/details/48823513
*/

class Vector2D {

    public Vector2D(List<List<Integer>> vec2d) {
        row = vec2d.iterator();
        if (row.hasNext())
            col = row.next().iterator();
    }

    public int next() {
        int lastValue = col.next();
        return lastValue;
    }

    public boolean hasNext() {
        if (col == null) {
            return false;
        }
        if (col.hasNext()) {
            return true;
        } else {
            while (row.hasNext()) {
                col = row.next().iterator();
                if (col.hasNext()) {
                	return true;
                }
            }
            return false;
        }
    }
    
    private Iterator<List<Integer>> row = null;
    private Iterator<Integer> col = null;
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */