/*
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. 
The digits are stored in reverse order, and each of their nodes contains a single digit. 
Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }*/
class Solution {
    //Time complexity : O(max(m,n)). Assume that mm and nn represents the length of l1 and l2 respectively, the algorithm above iterates at max(m,n) times.
    //Space complexity : O(max(m,n)). The length of the new list is at mostmax(m,n)+1.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode node = prehead;    
        int carry = 0;
        while (l1 != null || l2 != null) {
            int num1 = 0;
            int num2 = 0;
            
            if (l1 != null) {
                num1 +=  l1.val;
                l1 = l1.next;
            } 
            if (l2 != null) {
                num1 += l2.val;
                l2 = l2.next;
            }
            int sum = carry + num1 + num2;
            int sumNoCarry = sum % 10;
            carry = (sum - sumNoCarry >= 10) ? 1 : 0;
            
            node.next = new ListNode(sumNoCarry);
            node = node.next;
        }
        if (carry == 1) { 
          node.next = new ListNode(carry);
        }
        return prehead.next;
    }
}