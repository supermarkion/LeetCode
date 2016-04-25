/*
    There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. 
    You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new 
    language.Derive the order of letters in this language.
    
    Link: https://leetcode.com/problemset/algorithms/

    Example: 
	    For example,
		Given the following words in dictionary,

		[
		  "wrt",
		  "wrf",
		  "er",
		  "ett",
		  "rftt"
		]
		The correct order is: "wertf".
	
    Solution: None

    Source: http://blog.csdn.net/pointbreak1/article/details/48761705
*/

import java.util.Iterator;

public class Solution {
    public String alienOrder(String[] words) {
        if (words.length == 0) {
        	return "";
        }

        HashMap<Character, List<Character>> d = new HashMap<>();
        HashMap<Character, Boolean> used = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                if (!used.containsKey(words[i].charAt(j))) {
                	used.put(words[i].charAt(j), false);
                }
            }
        }

        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String cur = words[i];
            int j = 0;
            while (j < Math.min(pre.length(), cur.length())) {
                if (pre.charAt(j) != cur.charAt(j)) {
                    if (!d.containsKey(pre.charAt(j))) {
                        List<Character> l = new ArrayList<>();
                        l.add(cur.charAt(j));
                        d.put(pre.charAt(j), l);
                    } else {
                        d.get(pre.charAt(j)).add(cur.charAt(j));
                    }
                    break;
                }
                j++;
            }
        }

        StringBuffer sb = new StringBuffer();
        Iterator it = d.keySet().iterator();
        while (it.hasNext()) {
            char cur = (char)it.next();
            if (!used.get(cur)) {
                Set<Character> loop = new HashSet<>();
                boolean result = topologicalSort(d, used, cur, loop, sb);
                if (result) {
                	return "";
                }
            }
        }

        it = used.keySet().iterator();
        while (it.hasNext()) {
            char cur = (char)it.next();
            if (!used.get(cur))
                sb.insert(0, cur);
        }
        return sb.toString();
    }

    boolean topologicalSort(HashMap<Character, List<Character>> d, HashMap<Character, Boolean> used, char cur, Set<Character> loop, StringBuffer sb) {
        used.put(cur, true);
        loop.add(cur);
        if (d.containsKey(cur)) {
            for (char i : d.get(cur)) {
                if (loop.contains(i)) {
                	return true;
                }
                if (!used.get(i)) {
                    boolean result = topologicalSort(d, used, i, loop, sb);
                    if (result) {
                    	return true;
                    }
                }
            }
        }
        sb.insert(0, cur);
        return false;
    }
}