/*
    Given a string, sort it in decreasing order based on the frequency of characters.
    
    Link: https://leetcode.com/problems/sort-characters-by-frequency/

    Example: 
    	
    	Example 1:
			Input:
				"tree"
			Output:
				"eert"
			Explanation:
				'e' appears twice while 'r' and 't' both appear once.
			So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

		Example 2:
			Input:
				"cccaaa"
			Output:
				"cccaaa"
			Explanation:
				Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
			Note that "cacaca" is incorrect, as the same characters must be together.

		Example 3:
			Input:
				"Aabb"
			Output:
				"bbAa"
			Explanation:
				"bbaA" is also a valid answer, but "Aabb" is incorrect.
			Note that 'A' and 'a' are treated as two different characters.

    Solution: None

    Source: https://discuss.leetcode.com/topic/65947/o-n-easy-to-understand-java-solution/2
*/

public class Solution {
    public String frequencySort(String s) {
        int[] freq = new int [256];
        for (char ch: s.toCharArray()) {
        	freq[ch]++;
        }
        TreeMap<Integer, List<Character>> tree = new TreeMap<Integer, List<Character>>();
        for (int i=0; i < freq.length; i++) {
            if (freq[i] > 0) {
                if (!tree.containsKey(freq[i])) {
                    tree.put(freq[i], new LinkedList<Character>());
                }
                tree.get(freq[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(tree.size() > 0) {
            Map.Entry<Integer, List<Character>> entry = tree.pollLastEntry();
            for (Character ch: entry.getValue()) {
                sb.append(new String(new char[entry.getKey()]).replace('\0', ch));
            }
        }
        return sb.toString();
    }
}