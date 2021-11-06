//Write a code to partition a linked list around a value x, such that all nodes
//less than x come before all nodes greater than or equal to x

//Q: am I given the head of the linked list, and x are parameters? - YES
//Q: does it matter the order before or after as long has they are greater or less than x - NO
//Q: single linked list? - yes




public class Node {
    public int val;
    public Node next;
    Node(int val = 0, Node next = null) {
        val = val;
        next = next;
    }
}

public class Program {

    public Node Partition(Node head, int x) {

        Node lesser = null;
        Node p1 = null;
        Node greater = null;
        Node p2 = null;


        while (head.next != null) {

            if (head.val < x) {
                if (lesser == null) {
                    lesser = head;
                    p1 = lesser;
                } else {
                    lesser.next = head;
                }
            } else if (head.val >= x) { 
                if (greater == null) {
                    greater = head;
                    p2 = greater;
                } else {
                    greater.next = head;
                }
            }

            head = head.next;
            
        }

        //merge end of lesser with head of greater
        lesser.next = p2;

        //return head of lesser (entire list)
        return p1;

    }

}