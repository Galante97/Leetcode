//19. Remove Nth Node From End of List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode RemoveNthFromEnd(ListNode head, int n) {
            ListNode temp = new ListNode(0);
            temp.next = head;

            ListNode curr = temp;
            ListNode nBack = temp;

            for(int i = 0; i < n + 1; i++) {
                curr = curr.next;
            }

            while(curr != null)
            {
                curr = curr.next;
                nBack = nBack.next;
            }

            nBack.next = nBack.next.next;

            return temp.next;
    

    }
}