/*
    Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
    write a function to find the number of connected components in an undirected graph.
    
    Link: https://leetcode.com/problemset/algorithms/

    Example: 
	    Example 1:
		     0          3
		     |          |
		     1 --- 2    4
		Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

		Example 2:
		     0           4
		     |           |
		     1 --- 2 --- 3
		Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

    Solution: None

    Source: https://leetcode.com/discuss/93076/easy-to-understand-bfs-java-o-n-accepted-solution
*/

public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n == 0) return 0;

        // construct a graph
        List<List<Integer>> connects = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) 
            connects.add(new ArrayList<Integer>());
        for (int[] edge : edges)    {
            int a = edge[0], b = edge[1];
            connects.get(a).add(b);
            connects.get(b).add(a);
        }

        // then visit
        int numIslands = 0;
        boolean []visited = new boolean[n];
        Queue<Integer> frontier = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            // found a new island
            numIslands++;

            // explore the island starting from i
            frontier.add(i);
            while (!frontier.isEmpty()) {
                int p = frontier.remove();
                if (visited[p]) continue;
                visited[p] = true;

                List<Integer> connect = connects.get(p);
                for (int q : connect)   {
                    if (visited[q]) continue;
                    frontier.add(q);
                }
            }
        }

        return numIslands;
    }
}