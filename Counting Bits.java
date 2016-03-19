/*
   	Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their 
   	binary representation and return them as an array.

    Link: https://leetcode.com/problems/counting-bits/

    Example: For num = 5 you should return [0,1,1,2,1,2].

    Solution: The main point is that next block is current block + [1 + j for i in current block].

    Source: https://leetcode.com/discuss/92824/share-my-4ms-ac-java-solution
*/

public class Solution {
    int[] ans;
    public int[] countBits(int num) {
        ans = new int[num + 1];
        if (num == 0) {
        	return ans;
        }

        countBitsHelper(num, 1, 2);
        return ans;
    }
    
    private void countBitsHelper(int num, int start, int end) {
        int i;
        for (i = start; i < end && i <= num; i++) {
            ans[i] = 1 + ans[i - start];				// the next block is last block plus 1 and repeat
        }
        if (end <= num) {
        	countBitsHelper(num, i, 2 * i);
        } else {
        	return;
        }
    }
}
