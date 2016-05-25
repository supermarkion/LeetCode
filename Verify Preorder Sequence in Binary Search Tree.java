/*
    Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
	You may assume each number in the sequence is unique.
    
    Link: https://leetcode.com/problemset/algorithms/

    Example: None

    Solution: None

    Source: http://www.cnblogs.com/yrbbest/p/5014943.html
*/

public class Solution {
    public boolean verifyPreorder(int[] preorder) {
        int low = Integer.MIN_VALUE, index = -1;
        for (int i : preorder) {
            if(i < low) {
            	return false;
            }   
            while (index >= 0 && i > preorder[index]) {
            	low = preorder[index--];
            }
            preorder[++index] = i;
        }
        
        return true;
    }
}