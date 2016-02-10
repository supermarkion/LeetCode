/*
    The gray code is a binary numeral system where two successive values differ in only one bit.
    Given a non-negative integer n representing the total number of bits in the code, print the 
    sequence of gray code. A gray code sequence must begin with 0.

    Link: https://leetcode.com/problems/gray-code/

    Example: For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
        00 - 0
        01 - 1
        11 - 3
        10 - 2

    Solution: It based on move and or operations.
    
    Source: None
*/

public class Solution {
    public List<Integer> grayCode(int n) {
        if (n < 0) {
            return null;
        }
        List<Integer> currGray = new ArrayList<Integer>();
        currGray.add(0);
        for (int i = 0; i < n; i++) {
            int msb = 1 << i;
            for (int j = currGray.size() - 1; j >= 0; j--) {
                currGray.add(msb | currGray.get(j));
            }
        }
        return currGray;
    }
}