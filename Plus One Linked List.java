/*
    Given a non-negative number represented as a singly linked list of digits, plus one to the number.
    The digits are stored such that the most significant digit is at the head of the list.
    
    Link: https://leetcode.com/problems

    Example: 
    	Input:
        1->2->3

        Output:
        1->2->4
    
    Solution: None

    Source: http://blog.csdn.net/jmspan/article/details/51780132
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
    private ListNode reverse(ListNode head) {  
        ListNode prev = null;  
        ListNode current = head;  
        while (current != null) {  
            ListNode next = current.next;  
            current.next = prev;  
            prev = current;  
            current = next;  
        }  
        return prev;  
    }  
    public ListNode plusOne(ListNode head) {  
        if (head == null) {
            return null;  
        }
        ListNode reversed = reverse(head);  
        reversed.val ++;  
        ListNode current = reversed;  
        while (current != null && current.val >= 10) {  
            current.val -= 10;  
            if (current.next == null) {  
                current.next = new ListNode(1);  
            } else {  
                current.next.val ++;  
            }  
            current = current.next;  
        }  
        reversed = reverse(reversed);  
        return reversed;  
    }  
}  

