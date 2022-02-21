/*
 * RemoveKFromList.Java
 * Note: Try to solve this task in O(n) time using O(1) additional space, where
 * n is the number of elements in the list, since this is what you'll be asked
 * to do during an interview.
 * 
 * Given a singly linked list of integers l and an integer k, remove all
 * elements from list l that have a value equal to k.
 * 
 * 
 * 
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
ListNode<Integer> solution(ListNode<Integer> l, int k) {
    ListNode<Integer> sentinel = new ListNode(-1);
    ListNode<Integer> p = sentinel;

    sentinel.next = l;
  
    while(p.next != null) {
        if(p.next.value == k){
            p.next = p.next.next;
        } else {
            p = p.next;
        }
    }
    
    return sentinel.next;
}
