/*
    Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
    Link: https://leetcode.com/problems/combinations/
    Example: If n = 4 and k = 2, a solution is:
    [
      [2,4],
      [3,4],
      [2,3],
      [1,2],
      [1,3],
      [1,4],
    ]
    Solution: Use recursion method to reduce k (size of each line), and increase start number
    to consturct lines by increasing order.
    Source: https://leetcode.com/discuss/71012/easy-java-recursive-solution
*/

public class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> temp = new ArrayList<Integer>();
        generateCombinations(1, n, temp, k);
        return result;
    }
    public void generateCombinations(int start, int end, List<Integer> temp, int k) {
        if (k == 0) {
            result.add(temp);
        }
        for (int i = start; i <= end; i++) {
            List<Integer> newTemp = new ArrayList<Integer>(temp);
            newTemp.add(i);
            generateCombinations(i + 1, end, newTemp, k - 1);
        }
    }
}