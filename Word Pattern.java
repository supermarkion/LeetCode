/*
    Given a pattern and a string str, find if str follows the same pattern.

    Link: https://leetcode.com/problems/word-pattern/

    Example: 
    	pattern = "abba", str = "dog cat cat dog" should return true.
		pattern = "abba", str = "dog cat cat fish" should return false.
		pattern = "aaaa", str = "dog cat cat dog" should return false.
		pattern = "abba", str = "dog dog dog dog" should return false.

    Solution: None

    Source: https://leetcode.com/discuss/80249/java-solution-without-using-hashmap
*/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) } {
        	return false;
        }
            
        Map<Object, Object> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char p = pattern.charAt(i);
            String s = strs[i];
    
            if (map.containsKey(p) != map.containsKey(s)) {
            	return false;
            }
            if (map.containsKey(p)) {
                if(!map.get(p).equals(map.get(s))) {
                	return false;
                }
            } else {// map does not have p or s.
                // p => i => s, forms  bijection.
                map.put(p, i);
                map.put(s, i);    
            }
    
        }
    
        return true;
    }
}