/*
    Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
    
    Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/

    Example: For example,
		Given 1->2->3->3->4->4->5, return 1->2->5.
		Given 1->1->1->2->3, return 2->3.

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
        ListNode dummy_head = new ListNode(0);
        ListNode pre = dummy_head;
        while (head != null) {
            if (head.next != null && head.next.val == head.val) {
                int val = head.val;
                while (head != null && head.val == val) {
                    head = head.next;
                }
                pre.next = head; // if this head is dupilcate, also delete
            } else {
                pre.next = head;
                pre = head;
                head = head.next; // only link to 'clear' head node
            }
        }
        return dummy_head.next;
    }
}