 /*
    Given a pattern and a string str, find if str follows the same pattern. Here follow means a full match, 
    such that there is a bijection between a letter in pattern and a non-empty substring in str.
    
    Link: https://leetcode.com/problemset/algorithms/

    Example: 
		  pattern = "abab", str = "redblueredblue" should return true.
      pattern = "aaaa", str = "asdasdasdasd" should return true.
      pattern = "aabb", str = "xyzabcxzyabc" should return false. 
	
    Solution: None

    Source: http://www.chenguanghe.com/word-pattern-ii/
*/

public boolean wordPatternMatch(String pattern, String str) {
        HashMap map = new HashMap();
        return dfs(pattern, 0, str, 0, map);
    }
    private boolean dfs(String pattern, int i, String str, int j, HashMap map){
        if (i == pattern.length() && j == str.length()){
            return true;
        }
        if (i == pattern.length() || j == str.length()){
            return false;
        }
        char c = pattern.charAt(i);
        for (int k = j; k < str.length(); k++){
            if(map.get(c) == map.get(str.substring(j, k+1))){
                Integer val = (Integer)map.get(c);
                if(val == null){/
                    map.put(pattern.charAt(i), i);
                    map.put(str.substring(j, k+1), i);
                }
                if(dfs(pattern, i+1, str, k+1, map)){//dfs
                    return true;
                }
                if(val == null){// backtracking
                    map.remove(pattern.charAt(i));
                    map.remove(str.substring(j, k+1));
                }
            }
        }
        return false;
    }