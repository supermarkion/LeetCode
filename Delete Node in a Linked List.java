/*
    Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
    
    Link: https://leetcode.com/problems/delete-node-in-a-linked-list/

    Example: Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the 
    linked list should become 1 -> 2 -> 4 after calling your function.

    Solution: None
    
    Source: https://leetcode.com/discuss/80834/simple-java-solution-1ms
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
    public void deleteNode(ListNode node) {
        ListNode n1 = null;
        n1 = node.next;
        if (n1 != null) {
            node.val = n1.val;
            node.next = n1.next;
        }
    }
}