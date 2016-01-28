/*
    Given a string containing only digits, restore it by returning all possible valid IP address combinations.

    Link: https://leetcode.com/problems/restore-ip-addresses/

    Example: For example:
		Given "25525511135",
		return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

    Solution: None

    Source: None
*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        // Bug 1: not length, but length().
        if (s == null || s.length() < 4 || s.length() > 12) {
            return ret;
        }
        
        dfs(s, new ArrayList<String>(), ret, 0);
        return ret;
    }
    
    public void dfs(String s, ArrayList<String> path, List<String> ret, int index) {
        // THE BASE CASE:
        int len = s.length();
        if (path.size() == 4) {
            // Create a solution.
            if (index == len) {
                StringBuilder sb = new StringBuilder();
                for (String str: path) {
                    sb.append(str);
                    sb.append(".");
                }
                sb.deleteCharAt(sb.length() - 1);
                
                // bug 3: forget this statement.
                ret.add(sb.toString());
            }
            
            return;
        }
        
        // 2/ 25 / 255
        // bug 2: i should < len.
        for (int i = index; i < index + 3 && i < len; i++) {
            String sub = s.substring(index, i + 1);
            if (s.charAt(index) == '0' && i != index) {
                // only allow 0, not 02, 022
                break;
            }
            
            if (!isValid(sub)) {
                continue;
            }
            
            path.add(sub);
            dfs(s, path, ret, i + 1);
            path.remove(path.size() - 1);
        }
    }
    
    public boolean isValid(String s) {
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}