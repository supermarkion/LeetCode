/*
    All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". 
    When studying DNA, it is sometimes useful to identify repeated sequences within the DNA. Write a function 
    to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

    Link: https://leetcode.com/problems/repeated-dna-sequences/

    Example: 
    	For example,
			Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
		Return:
			["AAAAACCCCC", "CCCCCAAAAA"].

    Solution: None
    
    Source: None
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> DNAMap = new HashMap<String, Integer>();
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < s.length() - 9; i++) {
            String subString = s.substring(i, i + 10);
            if (DNAMap.get(subString) != null) {
                DNAMap.put(subString, DNAMap.get(subString) + 1);
            } else {
                DNAMap.put(subString, 1);
            }
        }
        for (String subString : DNAMap.keySet()) {
            if (DNAMap.get(subString) > 1) {
                result.add(subString);
            }
        }
        return result;
    }
}