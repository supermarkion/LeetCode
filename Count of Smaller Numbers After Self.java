/*
    You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] 
    is the number of smaller elements to the right of nums[i].

    Link: https://leetcode.com/problems/count-of-smaller-numbers-after-self/

    Example: Given nums = [5, 2, 6, 1]
        To the right of 5 there are 2 smaller elements (2 and 1).
        To the right of 2 there is only 1 smaller element (1).
        To the right of 6 there is 1 smaller element (1).
        To the right of 1 there is 0 smaller element.
        Return the array [2, 1, 1, 0].

    Solution: None
		    
    Source: None
*/

public class Solution {
    int[] nums;
    List<Integer> sorted;
    Integer[] result;

    public List<Integer> countSmaller(int[] nums) {
        this.nums = nums;
        sorted = new ArrayList<>();
        result = new Integer[nums.length];
        for (int i = nums.length - 1; i > -1; i--) {
            int index = findIndex(nums[i]);
            result[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(result);
    }

    private int findIndex(int toInsert) {
        if (sorted.size() == 0) {
            return 0;
        }
        int start = 0, end = sorted.size() - 1;
        if (sorted.get(end) < toInsert) {
            return end + 1;
        } else if (sorted.get(start) >= toInsert) {
            return 0;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < toInsert) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}