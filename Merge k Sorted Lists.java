/*
    Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

    Link: https://leetcode.com/problems/merge-k-sorted-lists/

    Example: None

    Solution: Based on this problem, if we want to speed up merge several times, we have to apply divide and merge.
	Then, for the divide method, we divide a the lists into left part and right, and then perform merge them.
    
    Source: None
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length== 0) {
            return null;
        }
        return divide(lists, 0, lists.length - 1);
    }
    private ListNode divide(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start + 1 == end) {
            return merge2Lists(lists[start], lists[end]);
        }
        ListNode left = divide(lists, start, start + (end - start) / 2);
        ListNode right = divide(lists, start + (end - start) / 2 + 1, end);
        return merge2Lists(left, right);
    }
    private ListNode merge2Lists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode last = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                last.next = left;
                left = left.next;
            } else {
                last.next = right;
                right = right.next;
            }
            last = last.next;
        }
        last.next = (left != null) ? left : right;
        return dummy.next;
    }
}