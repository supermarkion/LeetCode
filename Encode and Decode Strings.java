/*
    Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

    Link: https://leetcode.com

    Example: 
    	Machine 1 (sender) has the function:
		string encode(vector<string> strs) { // ... your code return encoded_string; } 
		Machine 2 (receiver) has the function: 
		vector<string> decode(string s) { //... your code return strs; }

		So Machine 1 does:
		string encoded_string = encode(strs); 
		and Machine 2 does:
		vector<string> strs2 = decode(encoded_string); 
		strs2 in Machine 2 should be the same as strs in Machine 1.

    Solution: None

    Source: https://segmentfault.com/a/1190000003791865
*/

public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();
        for (String str : strs) {
            output.append(String.valueOf(str.length()) + "#");
            output.append(str);
        }
        return output.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new LinkedList<String>();
        int start = 0;
        while (start < s.length()) {
            int idx = s.indexOf('#', start);
            int size = Integer.parseInt(s.substring(start, idx));
            res.add(s.substring(idx + 1, idx + size + 1));
            start = idx + size + 1;
        }
        return res;
    }
}