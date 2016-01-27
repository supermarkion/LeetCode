/*
    The set [1,2,3,…,n] contains a total of n! unique permutations. By listing and labeling all of the permutations in order.
    
    Link: https://leetcode.com/problems/permutation-sequence/

    Example: We get the following sequence (ie, for n = 3):
		"123"
		"132"
		"213"
		"231"
		"312"
		"321"

    Solution: We should simulation the process on how construct permutation.
    
    Source: None
*/

public class Solution {
    public String getPermutation(int n, int k) {
        if (n <= 0 && k <= 0) {
            return "";
        }
        int fact = 1;
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            fact *= i;
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            fact /= i;
            int rank = (k - 1) / fact;
            k = (k - 1) % fact + 1;
            sb.append(nums.get(rank));
            nums.remove(rank);
        }
        return sb.toString();
    }
}