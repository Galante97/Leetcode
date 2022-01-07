/*
 * 876. Middle of the Linked List
 * Given the head of a singly linked list, return the middle node of the linked
 * list.
 * If there are two middle nodes, return the second middle node.
 * 
 * Example 1:
    * Input: head = [1,2,3,4,5]
    * Output: [3,4,5]
    * Explanation: The middle node of the list is node 3.
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
    // Time Complexity: O(N), where N is the number of nodes in the given list.
    // Space Complexity: O(1), the space used by slow and fast
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}