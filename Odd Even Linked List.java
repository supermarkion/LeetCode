/*
    Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking 
    about the node number and not the value in the nodes. You should try to do it in place. The program should run in O(1) 
    space complexity and O(nodes) time complexity.

    Link: https://leetcode.com/problems/odd-even-linked-list/

    Example: 
    	Given 1->2->3->4->5->NULL,
		return 1->3->5->2->4->NULL.

    Solution: None
		    
    Source: https://leetcode.com/discuss/83142/java-easy-version-to-understand
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
        	return head;
        }
        ListNode head1 = head, head2 = head.next, p = head1, q = head2, pass = head2.next;
        while (pass != null) {
            p.next = pass;
            p = p.next;
            pass = pass.next;
            if (pass != null) {
                q.next = pass;
                q = q.next;
                pass = pass.next;
            }
        }
        p.next = head2;
        q.next = null;
        return head;
    }
}