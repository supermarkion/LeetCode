/*
    Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
		"abc" -> "bcd" -> ... -> "xyz"
	Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.
    
    Link: https://leetcode.com

    Example: 
    	For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
		Return:
		[
		  ["abc","bcd","xyz"],
		  ["az","ba"],
		  ["acef"],
		  ["a","z"]
		]
    
    Solution: None

    Source: http://blog.csdn.net/pointbreak1/article/details/48780345
*/

public class Solution {  
    public List<List<String>> groupStrings(String[] strings) {  
        List<List<String>> result = new ArrayList<List<String>>();  
        HashMap<String, List<String>> d = new HashMap<>();  
        for (int i = 0; i < strings.length; i++) {  
            StringBuffer sb = new StringBuffer();  
            for (int j = 0; j < strings[i].length(); j++) {  
                sb.append(Integer.toString(((strings[i].charAt(j) - strings[i].charAt(0)) + 26) % 26));  
                sb.append(" ");  
            }  
            String shift = sb.toString();  
            if (d.containsKey(shift)) {  
                d.get(shift).add(strings[i]);  
            } else {  
                List<String> l = new ArrayList<>();  
                l.add(strings[i]);  
                d.put(shift, l);  
            }  
        }  
          
        for (String s : d.keySet()) {  
            Collections.sort(d.get(s));  
            result.add(d.get(s));  
        }   
        return result;  
    }  
}  