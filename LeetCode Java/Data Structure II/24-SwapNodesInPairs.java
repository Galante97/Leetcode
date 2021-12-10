/* 24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head. 
You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 Example:
    Input: head = [1,2,3,4]
    Output: [2,1,4,3]
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
    //Time Complexity : O(N)
    //Space Complexity : O(1)
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        // sentinel
        ListNode sentinel = new ListNode(0, head);
        
        ListNode prev = sentinel;
        ListNode curr = head;
        ListNode next = head.next;
        
        while(curr != null && curr.next != null) {
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            
            prev = curr;
            curr = curr.next;
            
            if (curr == null) {break;}
            
            next = curr.next;
        
        }
        
        return sentinel.next;
    }
}