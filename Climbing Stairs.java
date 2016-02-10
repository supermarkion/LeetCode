/*
    You are climbing a stair case. It takes n steps to reach to the top. Each time you can either climb 1 or 2 steps. 
    In how many distinct ways can you climb to the top?

    Link: https://leetcode.com/problems/climbing-stairs/
    
    Example: None

    Solution: None
    
    Source: None
*/

public class Solution {
    public int climbStairs(int n) {
        if (n < 1) {
            return 1;
        }
        
        int past = 1;
        int last = 1;
        int now = 1;
        
        for (int i = 2; i < n + 1; i++) {
            now = past + last;
            last = past;
            past = now;
        }
        
        return now;
    }
}