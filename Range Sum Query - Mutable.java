/*
    Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive. The update(i, val) 
    function modifies nums by updating the element at index i to val.

    Link: https://leetcode.com/problems/range-sum-query-mutable/

    Example: 
    	Given nums = [1, 3, 5]
	sumRange(0, 2) -> 9
	update(1, 2)
	sumRange(0, 2) -> 8

    Solution: None
		    
    Source: https://leetcode.com/discuss/72658/java-solution-with-binary-indexed-tree-beats-81-95%25
*/

public class NumArray {

    private int[] tree;
    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        int sum = 0;
        int lowbit;
        tree = new int[nums.length + 1];
        for (int i = 1; i < tree.length; i++) {
            sum = 0;
            lowbit = i & (-i);
            for (int j = i; j > i - lowbit; j--) {
                sum = sum + nums[j - 1];
            }
            tree[i] = sum;
        }
    }

    void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        i++;
        for (; i < tree.length; i = i + (i & (-i))) {
            tree[i] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

    public int getSum(int i) {
        int sum = 0;
        i++;
        while (i > 0) {
            sum = sum + tree[i];
            i = i - (i & (-i));
        }
        return sum;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);