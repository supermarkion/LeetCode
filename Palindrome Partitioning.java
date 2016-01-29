/*
    Given a string s, partition s such that every substring of the partition is a palindrome. Return all 
    possible palindrome partitioning of s.

    Link: https://leetcode.com/problems/palindrome-partitioning/

    Example: For example, given s = "aab",
        Return
          [
            ["aa","b"],
            ["a","a","b"]
          ]

    Solution: None
    
    Source: https://leetcode.com/discuss/81400/java-easy-understanding-solution
*/

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> rst = new ArrayList<>();
        partition(s , rst, new ArrayList<String>(), 0, 0);
        return rst;
    }
    
    private void partition(String s, List<List<String>> rst, List<String> path, int k, int sum){
        if(sum == s.length()) {
            rst.add(new ArrayList(path));
            return;
        }
    
        for(int i = k; i < s.length(); i++) {
            String tmp = s.substring(k, i + 1);
            if(isPalidrome(tmp)) {
                path.add(tmp);
                partition(s, rst, path, i + 1, sum + i - k + 1);
                path.remove(path.size() - 1);
            }
        }
    }
    
    public boolean isPalidrome(String s){
        for(int i = 0; i < s.length() / 2; i++){
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }        
        }
        return true;
    }
}