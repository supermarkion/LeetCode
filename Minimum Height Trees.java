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

    Solution: 
        建立一个图g，是一个二维数组，其中g[i]是一个一维数组，保存了i节点可以到达的所有节点。还需要一个一维数组d用来保存各个节点的入度信息，
        其中d[i]表示i节点的入度数。我们的目标是删除所有的叶节点，叶节点的入度为1，所以我们开始将所有入度为1的节点(叶节点)都存入到一个队列queue中，
        然后我们遍历每一个叶节点，通过图来找到和其相连的节点，将该节点的入度减1，如果该节点的入度减到1了，说明此节点也也变成一个叶节点了，加入队列中，
        再下一轮删除。那么我们删到什么时候呢，当节点数小于等于2时候停止，此时剩下的一个或两个节点就是我们要求的最小高度树的根节点
    Source: 
        https://leetcode.com/discuss/71804/java-layer-by-layer-bfs
        http://www.cnblogs.com/grandyang/p/5000291.html
*/

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Set<Integer> []adj = (Set<Integer>[]) new HashSet[n];
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            ans.add(i);
        }
        for (int i = 0; i < n; i++) {
            adj[i] = new HashSet<>();
        }
    
        for (int i = 0; i < n - 1; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            adj[from].add(to);
            adj[to].add(from);
        }
    
        Set<Integer> leaves = new HashSet<>();
        while(ans.size() > 2) {
            for (int v : ans) {
                if (adj[v].size() == 1) {
                    leaves.add(v);
                }
            }
            ans.removeAll(leaves);
            Set<Integer> nxtLeaves = new HashSet<>();
            for (int v : leaves) {
                int adjNode = adj[v].iterator().next();
                adj[adjNode].remove(v);
                if (adj[adjNode].size() == 1) {
                    nxtLeaves.add(adjNode);
                }
            }
            leaves = nxtLeaves;
        }
        return new ArrayList<>(ans);
    }
}