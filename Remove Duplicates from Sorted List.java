/*
    Given a sorted linked list, delete all duplicates such that each element appear only once.

    Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/

    Example: For example,
		Given 1->1->2, return 1->2.
		Given 1->1->2->3->3, return 1->2->3.

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head.next != null) {
            while (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            }
            if (head.next == null) {
                break;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}