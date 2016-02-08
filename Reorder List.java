/*
    Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→… 
    You must do this in-place without altering the nodes' values.

    Link: https://leetcode.com/problems/reorder-list/

    Example: Given {1,2,3,4}, reorder it to {1,4,2,3}.

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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // find middle
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rHead = slow.next;
        slow.next = null;

        // reverse ListNode on the right side
        ListNode prev = null;
        while (rHead != null) {
            ListNode temp = rHead.next;
            rHead.next = prev;
            prev = rHead;
            rHead = temp;
        }

        // merge two list
        rHead = prev;
        ListNode lHead = head;
        while (lHead != null && rHead != null) {
            ListNode temp1 = lHead.next;
            lHead.next = rHead;
            rHead = rHead.next;
            lHead.next.next = temp1;
            lHead = temp1;
        }
    }
}