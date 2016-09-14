/*
    Equations are given in the format A / B = k, where A and B are variables represented as strings, and k 
    is a real number (floating point number). Given some queries, return the answers. If the answer does 
    not exist, return -1.0.
    
    Link: https://leetcode.com/problems/evaluate-division/

    Example: 
		Given a / b = 2.0, b / c = 3.0. 
		queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
		return [6.0, 0.5, -1.0, 1.0, -1.0 ].

		The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

		According to the example above:
			equations = [ ["a", "b"], ["b", "c"] ],
			values = [2.0, 3.0],
			queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
			The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

    Source: https://discuss.leetcode.com/topic/58738/java-bfs-5ms
*/

class Tuple{
    public String var;
    public double val;
    public Tuple(String var, double val) {
        this.var = var;
        this.val = val;
    }   
}

public class Solution {
    private HashMap<String, HashSet<String>> graph = new HashMap<>();
    private HashMap<String, Double> valuesMap = new HashMap<>();
    private double query (String[] q) { 
        if (q.length == 0){ 
            return - 1; 
        }   
        LinkedList<Tuple> q1 = new LinkedList<>();
        LinkedList<Tuple> q2 = new LinkedList<>();
        q1.push(new Tuple(q[0], 1));
        HashSet<String> visited = new HashSet<>();
        visited.add(q[0]);
        while (!q1.isEmpty()) {
            q2 = q1; 
            q1 = new LinkedList<>();
            
            while (!q2.isEmpty()) {
                Tuple crt = q2.getFirst();
                q2.removeFirst();
                HashSet<String> neighbors = graph.get(crt.var);
                
                if (neighbors == null) {
                    continue;
                }
                for (String next : neighbors) {
                    if (!visited.contains(next)) {
                        Tuple tpl = new Tuple(next, crt.val);
                        if (valuesMap.containsKey(crt.var + "/" + next)) {
                            tpl.val = crt.val*valuesMap.get(crt.var+ "/" + next);
                        } else if (valuesMap.containsKey(next + "/" + crt.var)) {
                            tpl.val = crt.val/valuesMap.get(next+ "/" + crt.var);
                        }   
                        if (next.equals(q[1])) {
                            return tpl.val;
                        }   
                        visited.add(next);
                        q1.add(tpl);
                    }   
                }   
            }   
        }   
        return -1; 
    }   
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        if (equations.length == 0 || values.length != equations.length) {
            return null;
        }   
        for (int i=0; i < equations.length; ++i) {
            String[] equation = equations[i];
            if (!graph.containsKey(equation[0])) {
                graph.put(equation[0], new HashSet<>());
            }   
            if (!graph.containsKey(equation[1])) {
                graph.put(equation[1], new HashSet<>());
            }   
            graph.get(equation[0]).add(equation[1]);
            graph.get(equation[1]).add(equation[0]);
            valuesMap.put(equation[0] + "/" +  equation[1], values[i]);
        }   
        //System.out.println(graph);
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            if (queries[i][0].equals(queries[i][1]) && graph.containsKey(queries[i][0])) {
                res[i] = 1;
            } else {
            	res[i] = query(queries[i]);
            }
        }   
        return res;
    }   

}