/*
    Given numRows, generate the first numRows of Pascal's triangle.

    Link: https://leetcode.com/problems/pascals-triangle/

    Example: 
        For example, given numRows = 5,
		Return
		[
		     [1],
		    [1,1],
		   [1,2,1],
		  [1,3,3,1],
		 [1,4,6,4,1]
		]

    Solution: https://en.wikipedia.org/wiki/Pascal%27s_triangle
    
    Source: https://leetcode.com/discuss/84142/easy-2-ms-java-solution-with-comments
*/

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        //The result is stored in the array list result
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //if numRows is 0, return result
        if (numRows == 0) {
        	return result;
        }
        //ArrayList to store temporary row
        List<Integer> temp_row = new ArrayList<Integer>();
        //Base case, if numRows is 1
        temp_row.add(1);
        result.add(temp_row);
        //for loop to traverse for each row
        for (int i = 1; i < numRows; i++) {
            //store the most recent Arraylist in the result
            temp_row = result.get(i - 1);
            List<Integer> temp_solution = new ArrayList<Integer>();
            //Insert 1 at the beginning of the new arraylist
            temp_solution.add(0, 1);
            int j = 1;
            //perform calculation for middle elements
            while (j < i) {
                temp_solution.add(j, (temp_row.get(j)+  temp_row.get(j - 1)));
                j++;
            }
            //Insert 1 at the end of the new arraylist
            temp_solution.add(i, 1);
            //add the new arraylist to the result
            result.add(temp_solution);
        }
        //return the result
        return result;
    }
}