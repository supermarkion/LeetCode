/*
    Given a linked list, swap every two adjacent nodes and return its head.

    Link: https://leetcode.com/problems/swap-nodes-in-pairs/

    Example: Given 1->2->3->4, you should return the list as 2->1->4->3.

    Solution: None

    Source: https://leetcode.com/discuss/80322/java-implementation-for-time-o-n-space-o-1
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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
    
        ListNode c = head;
        head = c.next;
        ListNode p = null;
    
        while(c != null && c.next != null){
    
            ListNode cn = c.next;
            ListNode cnn = c.next.next;
            cn.next = c;
            c.next = null;
            if(p != null){
                p.next = cn;
            }
            p = c;
            c = cnn;
        }
    
        if(c != null && p != null){
            p.next = c;
            c.next = null;
        }
        return head;
    }
}