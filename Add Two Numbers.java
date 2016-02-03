/*
    You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their 
    nodes contain a single digit. Add the two numbers and return it as a linked list.

    Link: https://leetcode.com/problems/add-two-numbers/

    Example: 
   		Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 0 -> 8

    Solution: Use a carry, and two values in current nodes to construct next node values.
    
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        boolean carry = false; // it should be only true / false
        while (l1 != null || l2 != null || carry) {
            int temp1 = 0, temp2 = 0, temp3 = 0;
            if (l1 != null) {
                temp1 = l1.val;
            } 
            if (l2 != null) {
                temp2 = l2.val;
            }
            if (carry) {
                temp3 = 1;
            }
            int sum = temp1 + temp2 + temp3;
            ListNode curr = new ListNode(sum % 10);
            pre.next = curr;
            pre = pre.next;
            if (sum / 10 > 0) {
                carry = true;
            } else {
                carry = false;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return dummy.next;
    }
}