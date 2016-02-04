/*
    Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary 
    in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

    Note:
		If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
		All airports are represented by three capital letters (IATA code).
		You may assume all tickets may form at least one valid itinerary.

    Link: https://leetcode.com/problems/reconstruct-itinerary/

    Example: 
    	Example 1:
			tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
			Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
		Example 2:
			tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
			Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
			Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.

    Solution: Constructe a tree / graph, and perform dfs to traverse it. Moreover, we can use TreeMap to keep the lexical
    order of these ticket.
    
    Source: https://leetcode.com/discuss/84588/ac-java-solution-dfs-with-treemap
*/

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList();
        if (tickets == null || tickets.length == 0) {
        	return result;
        }

        // map key is source of airport. value save a k-v pair on desintion, and repeat times
        Map<String, TreeMap<String, Integer>> map = new HashMap();

        for (String[] pair : tickets) {
            if (!map.containsKey(pair[0])) {
            	map.put(pair[0], new TreeMap());
            }
            TreeMap<String, Integer> cache = map.get(pair[0]);
            cache.put(pair[1], cache.containsKey(pair[1]) ? cache.get(pair[1]) + 1 : 1);
        }

        // search from start airport
        dfs("JFK", map, result, tickets.length + 1);
        return result;
    }

    private boolean dfs(String curr, Map<String, TreeMap<String, Integer>> map, List<String> result, int size) {
        result.add(curr);
        if (result.size() == size) {
        	return true;
        }
        if (map.containsKey(curr)) {
            TreeMap<String, Integer> children = map.get(curr);

            for (String next : children.keySet()) {
                if (children.get(next) > 0) {
                    children.put(next, children.get(next) - 1); // once we itinerary, reduce one time
                    boolean res = dfs(next, map, result, size);
                    if (res) {
                    	return true;							// once finish search
                    }
                    children.put(next, children.get(next) + 1); // backtrack, this next is not the current part of solution
                }
            }
        }
        result.remove(result.size() - 1);						// also backtrack
        return false;
    }
}