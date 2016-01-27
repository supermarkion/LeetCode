/*
    Given an array of strings, group anagrams together.
    
    Link: https://leetcode.com/problems/anagrams/

    Example: given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
		Return:
			[
			  ["ate", "eat","tea"],
			  ["nat","tan"],
			  ["bat"]
			]

    Solution: None
    
    Source: https://leetcode.com/discuss/80478/24ms-short-java-solution
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] ar = s.toCharArray();
            Arrays.sort(ar);
            String sorted = String.valueOf(ar);
            List<String> list = map.get(sorted);
            if (list == null) {
                list = new ArrayList<String>();
            }
            list.add(s);
            map.put(sorted, list);
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> l : map.values()) {
            Collections.sort(l); // sort to make it follow lexicographic order
            res.add(l);
        }
        return res;
    }
}