/*
203. Remove Linked List Elements
Given the head of a linked list and an integer val, 
remove all the nodes of the linked list that has Node.val == val, and return the new head.

Example:
    Input: head = [1,2,6,3,4,5,6], val = 6
    Output: [1,2,3,4,5]
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
    //Time complexity: O(N), it's one pass solution.
    //Space complexity: O(1), it's a constant space solution.
    public ListNode removeElements(ListNode head, int val) {
           //Initiate sentinel node as ListNode(0) and set it to be the new head
           ListNode sentinel = new ListNode(0);
           sentinel.next = head;

            ListNode prev = sentinel;
            ListNode curr = head;
        
            while (curr != null) {
              if (curr.val == val) {
                  prev.next = curr.next;
              } else { 
                  prev = curr;
              }
                
                curr = curr.next;
            }
        
            return sentinel.next;
          }
}
