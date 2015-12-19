/*
    There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. 
    The overall run time complexity should be O(log (m+n)).
    Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
    Example: None
    Solution: There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
	We can solve this problem by find the kth number in a sorted array.
    Source: None
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length == 0) && (nums2 == null || nums2.length == 0)) {
        	return -1.0;
   		}
	    int lenA = (nums1 == null) ? 0 : nums1.length ;
	    int lenB = (nums2 == null) ? 0 : nums2.length ;
	    int len = lenA + lenB ;
	    // return median for even and odd cases
	    if (len % 2 == 0) {
	        return (findKth(nums1, 0 , nums2, 0, len / 2) 
	        	+ findKth(nums1, 0 , nums2, 0, len / 2 + 1) ) / 2.0;
	    } else {
	    	return findKth (nums1, 0, nums2, 0, len / 2 + 1);
	    }
        
    }
    private int findKth(int[] A, int indexA, int[] B, int indexB, int k) {
	    int lenA = (A == null) ? 0 : A.length ;
	    if (indexA > lenA - 1) {
	    	return B[indexB + k - 1];
	    }
	    int lenB = (B == null) ? 0 : B.length ;
	    if (indexB > lenB - 1) {
	    	return A[indexA + k - 1];
	    }

	    // avoid infilite loop if k == 1
	    if ( k == 1) {
	    	return Math.min(A[indexA], B[indexB]) ;
	    }
	    int keyA = Integer.MAX_VALUE, keyB = Integer.MAX_VALUE;
	    // then, perform binary search to find kth element
	    if (indexA + k / 2 - 1 < lenA) {
	    	keyA = A[indexA + k / 2 - 1];
	    }
	    if (indexB + k / 2 - 1 < lenB) {
	    	keyB = B[indexB + k / 2 - 1];
	    }
	    if (keyA > keyB) {
	    	return findKth(A, indexA, B, indexB + k / 2, k - k / 2);
	    } else {
	    	return findKth(A, indexA + k / 2, B, indexB, k - k / 2);
	    }
    }
}