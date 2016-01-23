/*
    Given a linked list, remove the nth node from the end of list and return its head.
    
    Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/

    Example: For example,
        Given linked list: 1->2->3->4->5, and n = 2.
        After removing the second node from the end, the linked list becomes 1->2->3->5.

    Solution: Two pointers method.
    
    Source: https://leetcode.com/discuss/79748/easy-java-two-pointers-solution
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head, slow = head;
        if(head == null){
            return null;
        }
        while(n != 0){       //walking n times forwrad
            fast = fast.next;
            n--;
        }
        if(fast == null ){    //if after initial walk fast == null, we know the nth element is the head
            return head.next;
        }
        while(fast.next != null){ 
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next; // remove the n the node
        return head;
    }
}