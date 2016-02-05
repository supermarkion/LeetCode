/*
    Compare two version numbers version1 and version2.
		If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

	You may assume that the version strings are non-empty and contain only digits and the . character.
	The . character does not represent a decimal point and is used to separate number sequences.

    Link: https://leetcode.com/problems/compare-version-numbers/

    Example: 
    	For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of 
    	the second first-level revision. Here is an example of version numbers ordering:
			0.1 < 1.1 < 1.2 < 13.37

    Solution: None
    
    Source: https://leetcode.com/discuss/84651/my-1ms-java-solution-beating-88-83%25-solutions
*/

public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2)) {
        	return 0;
        }
	     //If reach to the end
	    int flag1 = 0, flag2 = 0;

	    while (version1 != "" && version2 != "") {
	    	int d1 = 0, d2 = 0;
	      	int n1 = 0, n2 = 0;
	    
	      	if (flag1 == 0) {
	      		while (d1 < version1.length() && version1.charAt(d1) != '.') {
	        		n1 *= 10;
	        		n1 += version1.charAt(d1++) - '0';
	        	}
	      	} else {
	      		n1 = 0;
	      	}
	    
	      	if (flag2 == 0) {
	      		while (d2 < version2.length() && version2.charAt(d2) != '.') {
			        n2 *= 10;
			        n2 += version2.charAt(d2++) - '0';
			    } 
	      	} else {
	      		n2 = 0;
	      	}
	    
		    if (d1 < version1.length()) {
		      	version1 = version1.substring(d1 + 1);
		    } else {
		    	flag1 = 1;
		    }
		    
		    if (d2 < version2.length()) {
		    	version2 = version2.substring(d2 + 1);
		    } else {
		    	flag2 = 1;
		    }
		    
		    //output result
		    if (n1 > n2) {
		    	return 1;
		    }
		    
		    if (n1 < n2) {
		    	return -1;
		    }
		    
		    //handle "00001", "1"
		    if (n1 == n2 && (flag1 & flag2) == 1) {
		    	return 0;
		    }
	    }
	    return 0;
    }
}