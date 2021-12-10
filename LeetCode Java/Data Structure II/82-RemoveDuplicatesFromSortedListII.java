/*
82. Remove Duplicates from Sorted List II
Given the head of a sorted linked list, delete all nodes that have duplicate numbers, 
leaving only distinct numbers from the original list. Return the linked list sorted as well.
Examples:
    Input: head = [1,2,3,3,4,4,5]
    Output: [1,2,5] 
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        // sentinel
        ListNode sentinel = new ListNode(0, head);
        // predecessor = the last node 
        // before the sublist of duplicates
        ListNode pred = sentinel;
        
         while (head != null) {
           // if it's a beginning of duplicates sublist 
            // skip all duplicates
            if (head.next != null && head.val == head.next.val) {
                // move till the end of duplicates sublist
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;    
                }
                // skip all duplicates
                pred.next = head.next;     
            // otherwise, move predecessor
            } else {
                pred = pred.next;    
            }
                
            // move forward
            head = head.next;    
         }
         return sentinel.next;
    }
}