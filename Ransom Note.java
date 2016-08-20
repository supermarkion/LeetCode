/*
    Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  
    function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines;  otherwise,  
    it  will  return  false.   
	
	Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
    
    Link: https://leetcode.com/problems/ransom-note/

    Example: 
    	You may assume that both strings contain only lowercase letters.

		canConstruct("a", "b") -> false
		canConstruct("aa", "ab") -> false
		canConstruct("aa", "aab") -> true
    
    Solution: None

    Source: https://discuss.leetcode.com/topic/53864/java-o-n-solution-easy-to-understand
*/

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if(--arr[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}