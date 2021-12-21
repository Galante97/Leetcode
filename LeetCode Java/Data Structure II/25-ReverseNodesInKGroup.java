/*
25. Reverse Nodes in k-Group
Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
You may not alter the values in the list's nodes, only nodes themselves may be changed.
Example 1:
    Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]
*/
class Solution {
    // Time Complexity: O(N) since we process each node exactly twice. Once when we
    // are counting the number of nodes in each recursive call, and then once when
    // we are actually reversing the sub-list.
    // Space Complexity: O(1).
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) { return head; }
        ListNode sentinel = null;
        ListNode first = head;
        ListNode next = head.next;
        ListNode last = head;
        ListNode prevLast = null;
        boolean afterFirstLoop = false;
        while (last != null) { // iteritive double loop
            if (afterFirstLoop) { // move first and last pointers after each reverse
                first = movePointer(first, k + 1);
                last = movePointer(last, k * 2);
            } else { last = movePointer(last, k); }
            if (last != null && prevLast != null) { // connect the previous reversed bunch to the next bunch
                prevLast.next = last;
            }
            prevLast = first; // set the previous last to be connected later
            if (last == null) {
                break;
            } // done case
            next = first.next; // move next pointer
            while (first != next && first != last) { // reverse logic
                first.next = last.next;
                last.next = first;
                first = next;
                if (first == next && first == last) {
                    break;
                }
                next = next.next;
            }
            // sentinel needs to be set after first bunch is reversed
            if (sentinel == null) {
                sentinel = new ListNode(0, first);
            }
            afterFirstLoop = true;
        }
        return sentinel.next;
    }
    // helper function to move pointer k amount
    public ListNode movePointer(ListNode pointer, int k) {
        int counter = 1;
        while (pointer != null && counter < k) {
            pointer = pointer.next;
            counter++;
        }
        return pointer;
    }
}