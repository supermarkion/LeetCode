/*
    Remove all elements from a linked list of integers that have value val.

    Link: https://leetcode.com/problems/remove-linked-list-elements/

    Example: Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6. Return: 1 --> 2 --> 3 --> 4 --> 5

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
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (head != null) {
            while (head != null && head.val == val) {
                ListNode next = head.next;
                pre.next = next;
                head = next;
            }
            if (head != null) {
                pre = head;
                head = head.next;
            }
        }
        return dummy.next;
    }
}