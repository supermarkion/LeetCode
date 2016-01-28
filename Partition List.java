/*
    Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
    
    Link: https://leetcode.com/problems/partition-list/

    Example: 
    	Given 1->4->3->2->5->2 and x = 3,
		return 1->2->2->4->3->5.

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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy_smaller = new ListNode(0);
        ListNode dummy_larger = new ListNode(0);
        ListNode smaller = dummy_smaller;
        ListNode larger = dummy_larger;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                larger.next = head;
                larger = larger.next;
            }
            head = head.next;
        }
        smaller.next = dummy_larger.next;
        larger.next = null;

        return dummy_smaller.next;
    }
}