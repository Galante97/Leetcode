/*
 * 2 - isListPalindrome
 * Note: Try to solve this task in O(n) time using O(1) additional space, where
 * n is the number of elements in l, since this is what you'll be asked to do
 * during an interview.
 * 
 * Given a singly linked list of integers, determine whether or not it's a
 * palindrome.
 * 
 * Note: in examples below and tests preview linked lists are presented as
 * arrays just for simplicity of visualization: in real data you will be given a
 * head node l of the linked list
 */
// Singly-linked lists are already defined with this interface:
// class ListNode<T> {
//   ListNode(T x) {
//     value = x;
//   }
//   T value;
//   ListNode<T> next;
// }
//
boolean solution(ListNode<Integer> l) {
    String foward = "";
    String backwards = "";
    
    while (l != null) {
        foward += l.value.toString();
        backwards = l.value.toString() + backwards;
        
        l = l.next;
    }
    
    return foward.equals(backwards);

}
