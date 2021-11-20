/*
83. Remove Duplicates from Sorted List
Given the head of a sorted linked list, delete all duplicates such that each
 element appears only once. Return the linked list sorted as well.

Example:
    Input: head = [1,1,2,3,3]
    Output: [1,2,3]

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
    // Time complexity : OO(n). Because each node in the list is checked exactly once to determine if it
    // is a duplicate or not, where n is the number of nodes in the list.
    // Space complexity : O(1). No additional space is used.
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        
        ListNode sentinel = head;     
       
        ListNode prev = head;
        ListNode curr = head.next;
        
        while (curr != null) {
            //duplicate
            if (curr.val == prev.val) {
                prev.next = curr.next;
                curr = curr.next;
            } else {
                prev = prev.next;
                curr = curr.next;
            }
        }
        return sentinel;  
    }
}