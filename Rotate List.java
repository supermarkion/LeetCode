/*
    Given a list, rotate the list to the right by k places, where k is non-negative.
    Link: https://leetcode.com/problems/rotate-list/
    Example: 
    	Given 1->2->3->4->5->NULL and k = 2,
		return 4->5->1->2->3->NULL.
    Solution: We should compute the length of linklist to know the relationship between
    length and k, and then build a circle to save operation in the future.
    Source: https://leetcode.com/discuss/70063/java-ac-solution
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        int count = 1;
        while(p.next!= null){
            count++;
            p = p.next;
        }
        k = k % count;
        p.next = head;      /*make a circle here*/
        p = head;
        for(int i = 0; i < count - k - 1; i++){
            p = p.next;
        }
        ListNode dummy = p.next;
        p.next = null;
        return dummy;
    }
}