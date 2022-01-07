/*
 * 19. Remove Nth Node From End of List
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 * 
 * Example 1:
    * Input: head = [1,2,3,4,5], n = 2
    * Output: [1,2,3,5]
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // O(n)
    // O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinal = new ListNode(0, head);

        int count = 0;
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null) {
            if (count > n) { // once count is larger than n, start moving it, will trail n behind
                p1 = p1.next;
            }
            p2 = p2.next;
            count++;
        }

        if (count == n) { // remove first in LL
            return sentinal.next.next;
        } else if (count > 1) { // remove any other than first
            p1.next = p1.next.next;
            return sentinal.next;
        } else { // only 1 existed, remove it ie null
            return null;
        }

    }
}