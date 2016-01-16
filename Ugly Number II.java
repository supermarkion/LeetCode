/*
    Write a program to find the nth ugly number. Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
    
    Link: https://leetcode.com/problems/ugly-number-ii/

    Example: For example,
        1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

    Solution: None
    
    Source: https://leetcode.com/discuss/74099/java-solution-using-priorityqueue
*/

 public class Solution {
    public int nthUglyNumber(int n) {
        if(n==1) return n;
        Queue<Long> q = new PriorityQueue<Long>();
        int[] nums = {2, 3, 5};
        Long result = Long.valueOf(1);
        q.offer(result);
        for(int i = 0; i < n; i++){

            // Each time we poll the peak value of q, is the ith number 
            result = q.poll();
            for(int num : nums){
                Long uglyNum = result * num;
                if(!q.contains(uglyNum)){
                    q.offer(uglyNum);
                }
            }
        }
        
        return result.intValue();
    }
}