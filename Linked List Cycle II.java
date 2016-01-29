/*
    Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
    
    Link: https://leetcode.com/problems/linked-list-cycle-ii/

    Example: None

    Solution: None
    
    Source: None
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {  // There is a cycle.
                slow = head;
                // Both pointers advance at the same time.
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;  // slow is the begin of cycle.
            }
        }
        return null;  // No cycle.
    }
}