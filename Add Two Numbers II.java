/*
	You are given two non-empty linked lists representing two non-negative integers. The most 
	significant digit comes first and each of their nodes contain a single digit. Add the two 
	numbers and return it as a linked list.

	You may assume the two numbers do not contain any leading zero, except the number 0 itself.

	Link: https://leetcode.com/problems/add-two-numbers-ii/

    Example: 

	    Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
		Output: 7 -> 8 -> 0 -> 7

    Solution: None

    Source: https://discuss.leetcode.com/topic/74475/my-easy-understanding-java-recursive-solution
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
    int c = 0;   // it is the carry
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);
        ListNode dummy = new ListNode(-1);
        dummy.next = len1 >= len2 ? helper(l1, l2, len1-len2) : helper(l2, l1, len2-len1);
        if (c != 0) {
            ListNode newNode = new ListNode(c);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        return dummy.next;
    }
    
    int getLength(ListNode l) {
        ListNode cur = l;
        int c = 0;
        while (cur != null) {
            c++;
            cur = cur.next;
        }
        return c;
    }
    
    ListNode helper(ListNode l1, ListNode l2, int offset) {  // l1 is offset size header of l2
        if (offset != 0) {
            ListNode l = helper(l1.next, l2, offset - 1);
            int tmp = l1.val + c;
            ListNode newNode = new ListNode(tmp % 10);
            newNode.next = l;
            c = tmp / 10;
            return newNode;
        } else {
            if (l1 != null && l2 != null) {
                ListNode l = helper(l1.next, l2.next, offset);
                int tmp = l1.val + l2.val + c;
                ListNode newNode = new ListNode(tmp % 10);
                newNode.next = l;
                c = tmp / 10;
                return newNode;
            }
        }
        return null;
    }
}