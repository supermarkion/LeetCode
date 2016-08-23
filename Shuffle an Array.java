/*
    Shuffle a set of numbers without duplicates.

    Link: https://leetcode.com/problems/shuffle-an-array/

    Example: 
        // Init an array with set 1, 2, and 3.
        int[] nums = {1,2,3};
        Solution solution = new Solution(nums);

        // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
        solution.shuffle();

        // Resets the array back to its original configuration [1,2,3].
        solution.reset();

        // Returns the random shuffling of array [1,2,3].
        solution.shuffle();

    Solution: None

    Source: https://discuss.leetcode.com/topic/54885/easy-to-understand-solution-java
*/

import java.util.Random;

public class Solution {
    int[] origin;
    Random rand;
    
    public Solution(int[] nums) {
        origin = nums;
        rand = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return origin;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (origin == null) {
            return null;
        }
        int n = origin.length;
        int[] dest = origin.clone();
        for (int i = n - 1; i >= 0; i--){
            int index = rand.nextInt(i + 1);
            int temp = dest[i];
            dest[i] = dest[index];
            dest[index] = temp;
        }
        return dest;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */