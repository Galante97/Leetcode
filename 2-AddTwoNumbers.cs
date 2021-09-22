//2. Add Two Numbers

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
    int carry = 0;

    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode prehead = new ListNode(-1);
        ListNode node = prehead;
        
        while(l1 != null || l2 != null) {
            node.next = new ListNode();
            node = node.next;
            
            int sum = createSum(l1, l2);           
            node.val = sum;

            if (l1 != null) 
                l1 = l1.next;   
            
            if (l2 != null)
                l2 = l2.next;
        }
        
        if (carry == 1) {
            node.next = new ListNode();
            node.next.val = 1;
        }
        
        return prehead.next;
        
    }
    
    public int createSum(ListNode l1, ListNode l2) {
        var val1 = l1 == null ? 0 : l1.val;
        var val2 = l2 == null ? 0 : l2.val;

        int sum = 0;
        
        if (carry == 1)
             sum = val1 + val2 + 1;
        else
            sum =  val1 + val2;

        if (sum >= 10) {
            sum -= 10;
            carry = 1;
        } else {
            carry = 0;
        }
        
        return sum;
    }
    
}