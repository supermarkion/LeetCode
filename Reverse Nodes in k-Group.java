/*
    Given a linked list, reverse the nodes of a linked list k at a time and return its modified list. 
    If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
	You may not alter the values in the nodes, only nodes itself may be changed. Only constant memory is allowed.

    Link: https://leetcode.com/problems/reverse-nodes-in-k-group/

    Example: None

    Solution: First of all, divided list to several k-groups, and reverse each group.
    
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head ==null || k == 1){
            return head;
        }
        ListNode dummy =new ListNode (0);
        dummy.next = head;
        ListNode pre=dummy;
        int i = 0;
        while (head != null){
            i++;
            if (i % k == 0) {
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
}