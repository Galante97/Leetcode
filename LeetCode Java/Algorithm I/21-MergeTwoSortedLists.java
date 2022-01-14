/*
21. Merge Two Sorted Lists

Merge two sorted linked lists and return it as a sorted list. 
The list should be made by splicing together the nodes of the first two lists.
Example:
    Input: l1 = [1,2,4], l2 = [1,3,4]
    Output: [1,1,2,3,4,4]
Constraints:
    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both l1 and l2 are sorted in non-decreasing order.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode merged = prehead;   
        //iterate through lists, pick smallest values and move pointers
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                merged.next = l1; 
                l1 = l1.next; 
            } else {
                merged.next = l2;
                l2 = l2.next;
            }
           merged = merged.next;

        }
        //append any remaining lists
        if (l1 != null) { merged.next = l1; }
        if (l2 != null) { merged.next = l2; }
        
        return prehead.next;    
    }
}