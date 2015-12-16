/*
    There are a total of n courses you have to take, labeled from 0 to n - 1. Some courses may have 
    prerequisites, for example to take course 0 you have to first take course 1, which is expressed 
    as a pair: [0,1]. Given the total number of courses and a list of prerequisite pairs, return 
    the ordering of courses you should take to finish all courses.
	There may be multiple correct orders, you just need to return one of them. If it is impossible 
	to finish all courses, return an empty array.
    Link: https://leetcode.com/problems/course-schedule-ii/
    Example: 
    	2, [[1,0]]
		4, [[1,0],[2,0],[3,1],[3,2]]

    Solution: Construct a graph, and search one solution.
    Source: https://leetcode.com/discuss/71446/java-13ms-iterative-dfs-solution-with-explanation
*/

 public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] visited = new int[numCourses];
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0 && dfsDetectCycle(graph, visited, stack, i)) return new int[0];
        }
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; i++) 
            order[i] = stack.pop();
        return order;
    }

    private boolean dfsDetectCycle(List<ArrayList<Integer>> graph, int[] visited,
                                              ArrayDeque<Integer> stack, int prere) {
        visited[prere] = -1; //Gray
        for (int course: graph.get(prere)) {
            if (visited[course] == -1) return true;
            else if (visited[course] == 0 && dfsDetectCycle(graph, visited, stack, course)) return true;
        }
        visited[prere] = 1; //Black
        stack.push(prere);
        return false;
    }
}