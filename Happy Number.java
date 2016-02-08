/*
    Write an algorithm to determine if a number is "happy". A happy number is a number defined by the following process: 
    Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process 
    until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers 
    for which this process ends in 1 are happy numbers.

    Link: https://leetcode.com/problems/happy-number/

    Example: 19 is a happy number
		1^{2} + 9^{2} = 82
		8^{2} + 2^{2} = 68
		6^{2} + 8^{2} = 100
		1^{2} + 0^{2} + 0^{2} = 1

    Solution: None
    
    Source: https://leetcode.com/discuss/81097/use-recursion-and-set
*/

public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        return check(n, set);
    }
    
    private boolean check(int n, Set<Integer> set) {
        if (n <1 0){
            if (n == 1) {
               return true;
            } else if (set.contains(n)) {
                return false;
            } else {
                set.add(n);
            }
            n = n * n;
        }
    
        int sum = 0;
        while (n >= 1) {
            sum += Math.pow(n % 10, 2);
            n = n / 10;
        }

    return check(sum, set);
    }
}