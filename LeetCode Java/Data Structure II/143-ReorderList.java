/*
 * 143. Reorder List
 * You are given the head of a singly linked-list. The list can be represented
 * as:
 * 
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * 
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may
 * be changed.
 * 
 */
class Solution {
    // Time complexity: O(N). There are three steps here. To identify the middle
    // node takes O(N) time. To reverse the second part of the list, one needs N/2
    // operations. The final step, to merge two lists, requires N/2N/2 operations as
    // well. In total, that results in O(N) time complexity.
    // Space complexity: O(1), since we do not allocate any additional data
    // structures.
    public void reorderList(ListNode head) {
        // find the middle of linked list [Problem 876]
        // in 1->2->3->4->5->6 find 4
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse the second part of the list [Problem 206]
        // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
        // reverse the second half in-place
        ListNode prev = null, curr = slow, tmp;
        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        // merge two sorted linked lists [Problem 21]
        // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
        ListNode first = head, second = prev;
        while (second.next != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }
}