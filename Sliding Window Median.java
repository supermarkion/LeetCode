/*
    Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle 
    value. So the median is the mean of the two middle value.

    Link: https://leetcode.com/problems/sliding-window-median/

    Example: 

        [2,3,4] , the median is 3

        [2,3], the median is (2 + 3) / 2 = 2.5

        Given an array nums, there is a sliding window of size k which is moving from the very left of the array 
        to the very right. You can only see the k numbers in the window. Each time the sliding window moves right 
        by one position. Your job is to output the median array for each window in the original array.

    Solution: None

    Source: https://discuss.leetcode.com/topic/74724/java-solution-using-two-priorityqueues
*/

public class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(
        new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        }
    );
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length - k + 1;
        if (n <= 0) return new double[0]; {
            double[] result = new double[n];
        } 
        for (int i = 0; i <= nums.length; i++) {
            if (i >= k) {
                result[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
                add(nums[i]);
            }
        }
            
        return result;
    }
    
    private void add(int num) {
        if (num < getMedian()) {
            maxHeap.add(num);
        }
        else {
            minHeap.add(num);
        }
        if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }
        
    private void remove(int num) {
        if (num < getMedian()) {
            maxHeap.remove(num);
        }
        else {
            minHeap.remove(num);
        }
        if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }
    }
        
    private double getMedian() {
        if (maxHeap.isEmpty() && minHeap.isEmpty()) return 0;
            
        if (maxHeap.size() == minHeap.size()) {
            return ((double)maxHeap.peek() + (double)minHeap.peek()) / 2.0;
        } else {
            return (double)minHeap.peek();
        }
    }
}