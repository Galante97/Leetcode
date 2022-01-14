/*
206. Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.
Example:
    Input: head = [1,2,3,4,5]
    Output: [5,4,3,2,1]
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //Time complexity : O(n). Assume that n is the list's length
    //Space complexity : O(1).
    public ListNode reverseList(ListNode head) {
        if (head == null) { return head; }
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode temp = curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = temp;
            
        }
        
        return prev;
    }
}