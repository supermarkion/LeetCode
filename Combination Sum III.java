/*
    Find all possible combinations of k numbers that add up to a number n, given that only numbers from 
    1 to 9 can be used and each combination should be a unique set of numbers. Ensure that numbers within 
    the set are sorted in ascending order.
    
    Link: https://leetcode.com/problems/combination-sum-iii/

    Example: 
        Example 1:
        Input: k = 3, n = 7
        Output:
        [[1,2,4]]

        Example 2:
        Input: k = 3, n = 9
        Output:
        [[1,2,6], [1,3,5], [2,3,4]]

    Solution: None
    
    Source: https://leetcode.com/discuss/81982/concise-java-solution-1ms
*/

public class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList();
        List<Integer> solution = new ArrayList();
        find(k, n, 1, solution);
        return result;
    }
    
    public void find(int k, int n, int start, List<Integer> solution){
        
        // k is number of number reminder, and if it is 1, mean add number can solve problem
        if (k == 1) { 
            List<Integer> current = new ArrayList(solution);
            if (n >= start && n <= 9) {
                current.add(n);
                result.add(current);
                return;
            } else {
                return;
            }
        }
        for (int i = start;i <= 10 - k; i++){
            List<Integer> current = new ArrayList(solution);
            current.add(i);
            find(k - 1, n - i, i + 1, current);
        }
    }
}