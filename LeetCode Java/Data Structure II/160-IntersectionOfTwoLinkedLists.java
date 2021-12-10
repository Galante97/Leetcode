/*
160. Intersection of Two Linked Lists
Given the heads of two singly linked-lists headA and headB, 
return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

For example, the following two linked lists begin to intersect at node c1
The test cases are generated such that there are no cycles anywhere in the entire linked structure.

Note that the linked lists must retain their original structure after the function returns.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //Time complexity : O(N+M)
    //Space complexity : O(N)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }  
        HashSet<ListNode> nodes = new HashSet<ListNode>();
    
        while (headA != null) {
            nodes.add(headA);
            headA = headA.next;
        }
        
        while (headB != null) {
            if (nodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;        
    }
}