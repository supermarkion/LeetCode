/*
	Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, 
	LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited 
	resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way
	 to maximize its total capital after finishing at most k distinct projects.

	You are given several projects. For each project i, it has a pure profit Pi and a minimum capital of Ci is 
	needed to start the corresponding project. Initially, you have W capital. When you finish a project, you 
	will obtain its pure profit and the profit will be added to your total capital.

	To sum up, pick a list of at most k distinct projects from given projects to maximize your final capital, 
	and output your final maximized capital.

    Link: https://leetcode.com/problems/ipo/

	Example: 
	
		Input: k=2, W=0, Profits=[1,2,3], Capital=[0,1,1].
		Output: 4
		Explanation: Since your initial capital is 0, you can only start the project indexed 0.
		             After finishing it you will obtain profit 1 and your capital becomes 1.
		             With capital 1, you can either start the project indexed 1 or the project indexed 2.
		             Since you can choose at most 2 projects, you need to finish the project indexed 2 to get the maximum capital.
		             Therefore, output the final maximized capital, which is 0 + 1 + 3 = 4.
		
    Solution: None

    Source: https://discuss.leetcode.com/topic/77811/java-48-ms-greedy-solution
*/

public class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        if (Profits == null || Profits.length == 0) {
        	return 0;
        }
        int n = Profits.length;
        PriorityQueue<Tuple> q = new PriorityQueue();
        for (int i = 0; i < n; i++) {
            q.add(new Tuple(Profits[i], Capital[i]));
        }
        while (!q.isEmpty() && k-- > 0) {
            Queue<Tuple> tmp = new ArrayDeque();
            while (!q.isEmpty() && q.peek().cap > W) {
            	tmp.add(q.poll());
            }
            if (q.isEmpty()) {
            	return W;
            }
            Tuple cur = q.poll();
            W += cur.pro;
            while (!tmp.isEmpty()) {
            	q.add(tmp.poll());
            }
        }
        return W;
    }
    
    class Tuple implements Comparable<Tuple> {
        int pro, cap;
        public Tuple(int pro, int cap) {
            this.pro = pro;
            this.cap = cap;
        }
        
        public int compareTo(Tuple that) {
            return that.pro - this.pro;
        }
    }
}