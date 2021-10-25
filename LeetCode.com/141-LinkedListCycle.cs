//141. Linked List Cycle
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public bool HasCycle(ListNode head) {
        HashSet<ListNode> nodesSeen = new HashSet<ListNode>();
        
        while (head != null) {
            if (nodesSeen.Contains(head)) {
                return true;
            }
            nodesSeen.Add(head);
            head = head.next;
        }
        return false;
    }
    
        
    
}