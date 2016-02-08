/*
    Given a linked list, determine if it has a cycle in it.

    Link: https://leetcode.com/problems/linked-list-cycle/

    Example: None

    Solution: Two pointer method, typical solution.
    
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
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null) {
            slow = slow.next;
            quick = quick.next;
            if (quick.next == null) {
                return false;
            } else {
                quick = quick.next;
            }
            if (quick == slow) {
                return true;
            }
        }
        return false;
    }
}