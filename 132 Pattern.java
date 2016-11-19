/*
    Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. 
    Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

    Note: n will be less than 15,000.
    
    Link: https://leetcode.com/problems/132-pattern/

    Example: 

        Example 1:
            Input: [1, 2, 3, 4]
            Output: False
            Explanation: There is no 132 pattern in the sequence.

        Example 2:
            Input: [3, 1, 4, 2]
            Output: True
            Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

        Example 3:
            Input: [-1, 3, 2, 0]
            Output: True
            Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
            
    Solution: None

    Source: https://discuss.leetcode.com/topic/68662/java-solution-20ms
*/

public class Solution {
    public boolean find132pattern(int[] nums) {
        ArrayList<Integer> table = new ArrayList<Integer>();
        int numsS = nums.length;
        if (numsS < 3) {
            return false;
        }
        
        int min = nums[0];
        
        for (int i = 1; i < numsS; i++) {
            if (nums[i] <= min){
                min = nums[i];
            } else {  
                int j = table.size() - 1;
                while (j > 0){
                    if (nums[i] <= table.get(j)) {
                        table.add(nums[i]);
                        table.add(min);
                        break;
                    } else {
                        if (nums[i] < table.get(j - 1)) {
                            return true;
                        } else {
                            table.remove(j);
                            table.remove(j - 1);
                        }
                    }
                    j = j - 2;
                }
                if (table.size() == 0) {
                    table.add(nums[i]);
                    table.add(min);
                }
            }
        }
        return false;
    }
}