/*
    There are a total of n courses you have to take, labeled from 0 to n - 1. Some courses may have prerequisites, 
    for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1] Given the total 
    number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

    Link: https://leetcode.com/problems/course-schedule/

    Example: For example:
		2, [[1,0]]
		There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

		2, [[1,0],[0,1]]
		There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 
		you should also have finished course 1. So it is impossible.

    Solution: None
    
    Source: https://leetcode.com/discuss/82347/java-easy-version-to-understand
*/

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
        	return false;
        }
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]]++;
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
            	queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < prerequisites.length; i++) {
                if (x == prerequisites[i][0]) {
                    inDegree[prerequisites[i][1]]--;
                    if (inDegree[prerequisites[i][1]] == 0) {
                    	queue.offer(prerequisites[i][1]);
                    }
                }
            }
        }
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0) {
            	return false;
            }
        }
        return true;
    }
}