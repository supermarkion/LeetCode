/*
    Merge two sorted linked lists and return it as a new list. The new list should be made by splicing 
    together the nodes of the first two lists.

    Link: https://leetcode.com/problems/merge-two-sorted-lists/

    Example: None

    Solution: None

    Source: https://leetcode.com/discuss/79939/simple-java-solution-with-explanation-1ms
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode tmp;
        if (l1.val > l2.val) {
            tmp = l2;
            l2 = l1;
            l1 = tmp;
        }
        ListNode p = l1;
        while (l2 != null) {
            while (p.next != null && p.next.val <= l2.val) p = p.next;
            tmp = p.next;
            p.next = l2;
            l2 = tmp;
        }
        return l1;
    }
}