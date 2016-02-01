/*
    Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and 
    only once. You must make sure your result is the smallest in lexicographical order among all possible results.

    Link: https://leetcode.com/problems/remove-duplicate-letters/

    Example: 
        Given "bcabc"
        Return "abc"

        Given "cbacdcbc"
        Return "acdb"

    Solution: None
		    
    Source: https://leetcode.com/discuss/82449/java-o-n-time-o-1-space-using-stack
*/

public class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, count + 1);
        }
        Set<Character> inStack = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (inStack.contains(c)) {
                map.put(c, map.get(c) - 1); 
                continue;
            }
            while (!stack.isEmpty()) {
                char top = stack.peek();
                if (map.get(top) > 1 && c < top) {
                    stack.pop();
                    inStack.remove(top);
                    map.put(top, map.get(top) - 1);
                } else {
                    break;
                }
            }
            stack.push(c);
            inStack.add(c);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }
}