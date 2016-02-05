/*
    There are N gas stations along a circular route, where the amount of gas at station i is gas[i]. You have a car with an 
    unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey 
    with an empty tank at one of the gas stations.
    
    Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

    Link: https://leetcode.com/problems/gas-station/

    Example: None

    Solution: In this problem, it has a main point that it may not exist the solution, which means that no matter where we
    start our car, the total gas is less than total cost. Then, we use a variables named total to make a decision
    on available solution. Moreover, it the current sum is greater than 0, then the start index is index plus one
    (because last time cause error, and assign this index).
    
    Source: None
*/

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
            return -1;
        }
        int sum = 0;
        int total = 0;
        int index = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];    // left gas in tank
            total += gas[i] - cost[i];  // total reminder gas after use
            if (sum < 0) {              // if we start at i index, we will fail
                index = i;
                sum = 0;
            }
        }
        if (total < 0) {                // if total gas is not enough, it is impossible to finish
            return -1;
        } else {
            return index + 1;
        }
    }
}