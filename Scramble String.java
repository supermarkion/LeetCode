/*
    Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

    Link: https://leetcode.com/problems/scramble-string/

    Example: Given 1->4->3->2->5->2->null and x = 3, return 1->2->2->4->3->5->null.

    Solution:
    	Below is one possible representation of s1 = "great":
		    great
		   /    \
		  gr    eat
		 / \    /  \
		g   r  e   at
		           / \
		          a   t
		To scramble the string, we may choose any non-leaf node and swap its two children.

		For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

		    rgeat
		   /    \
		  rg    eat
		 / \    /  \
		r   g  e   at
		           / \
		          a   t
		We say that "rgeat" is a scrambled string of "great".

		Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

		    rgtae
		   /    \
		  rg    tae
		 / \    /  \
		r   g  ta  e
		       / \
		      t   a
		We say that "rgtae" is a scrambled string of "great".

    Source: None
*/

public class Solution {
    public boolean isScramble(String s1, String s2) {
        int len = s1.length();
        if (len != s2.length()) {
            return false;
        }
        
        boolean[][][] canScramble = new boolean[len][len][len + 1];   // i,j with sublength
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                canScramble[i][j][1] = s1.charAt(i) == s2.charAt(j);    // substring start from i with length 1, compared with substring start from j with length 1
            }
        }
        
        for(int sublen = 2; sublen <= len; sublen++) {
            // end_pos = x+(sublen-1) <= len-1, so x <= len-sublen
            for(int i = 0; i <= len - sublen; i++) {
                for(int j = 0; j <= len - sublen; j++) {
                    for(int p = 1; p < sublen; p++) {       // split position
                        canScramble[i][j][sublen] |= (canScramble[i][j][p] && canScramble[i + p][j + p][sublen - p]) || 
                                                     (canScramble[i][j + sublen - p][p] && canScramble[i + p][j][sublen - p]);
                    }
                }
            }
        }
        
        return canScramble[0][0][len];
    }
}
