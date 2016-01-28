/*
    Reverse a linked list from position m to n. Do it in-place and in one-pass.

    Link: https://leetcode.com/problems/reverse-linked-list-ii/

    Example: For example:
		Given 1->2->3->4->5->NULL, m = 2 and n = 4,
		return 1->4->3->2->5->NULL.

    Solution: None

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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        for (int i = 0; i < m - 1; ++i) {
            prev = prev.next;
        }

        ListNode head2 = prev;

        prev = prev.next;
        ListNode cur = prev.next;

        for (int i = m; i < n; ++i) {
            prev.next = cur.next;  // remove cur from the list
            cur.next = head2.next; // add cur to the head
            head2.next = cur;       // add cur to the head
            cur = prev.next;        // get next cur
        }

        return dummy.next;
    }
}