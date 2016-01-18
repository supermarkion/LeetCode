/*
    Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
    So the median is the mean of the two middle value

    Link: https://leetcode.com/problems/find-median-from-data-stream/

    Example: 
    	[2,3,4] , the median is 3
		[2,3], the median is (2 + 3) / 2 = 2.5

    Solution: In this problem, we will apply priority queue to sort stream, and return the median when it needs. The
    main point is using two queue, and when facing a new number, we make a decision on which queue should
    be add, then when we face the size of two queues are not same, we change one elements in the larger queue
    to another. It is a temple by accessing median number by two prioirty queues.

    Source: https://leetcode.com/discuss/80600/java-easy-version-to-understand
*/

class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();//heap is a minimal heap by default
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());//change to a maximum heap
    
    // Adds a number into the data structure.
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
    }
    
    // Returns the median of current data stream
    public double findMedian() {
        if (maxHeap.size() == minHeap.size())
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        else
            return maxHeap.peek();
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();