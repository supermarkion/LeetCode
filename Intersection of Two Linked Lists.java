/*
    Write a program to find the node at which the intersection of two singly linked lists begins.

    Link: https://leetcode.com/problems/intersection-of-two-linked-lists/

    Example: For example, the following two linked lists:
		A:          a1 → a2
		                   ↘
		                     c1 → c2 → c3
		                   ↗            
		B:     b1 → b2 → b3
	begin to intersect at node c1.

    Solution: Get the diff between two list size, and make the longer one move diff step, then compare one step by step.
    
    Source: None
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode cur = headA;
        int lenA = 0;
        while (cur != null) {
            lenA++;
            cur = cur.next;
        }
        cur = headB;
        int lenB = 0;
        while (cur != null) {
            lenB++;
            cur = cur.next;
        }
        
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                headB = headB.next;
            }
        }
        while (headA != null || headB != null) {
            if (headA.val == headB.val) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}