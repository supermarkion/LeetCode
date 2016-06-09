/*
    You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another 
    if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
	What is the maximum number of envelopes can you Russian doll? (put one inside other)

    Link: https://leetcode.com/problems/russian-doll-envelopes/

    Example:  
        Given envelopes = [[5,4],[6,4],[6,7],[2,3]], the maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
    
    Solution: None

    Source: https://leetcode.com/discuss/107218/short-and-simple-java-solution-15-lines
*/

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
	    Arrays.sort(envelopes, (a, b) -> a[0] - b[0]);
	    int max = 0;
	    int dp [] = new int [envelopes.length];
	    for (int i = 0; i < envelopes.length; i++) {
	        dp[i] = 1;
	        for (int j = 0; j < i; j++) {
	            if (envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
	            	dp[i] = Math.max(dp[i], dp[j] + 1);
	            }
	        }
	        max = Math.max(dp[i], max);
	    }
	    return max;
    }

}