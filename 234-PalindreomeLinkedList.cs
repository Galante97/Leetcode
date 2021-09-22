//234. Palindrome Linked List

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
   public bool IsPalindrome(ListNode head) {
        ListNode copy = head;
        Stack<int> values = new Stack<int>();
        
        while (copy != null) {
            values.Push(copy.val);
            copy = copy.next;
        }
        
        while (values.Count > 0) {
            if (values.Pop() != head.val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
    
 
}