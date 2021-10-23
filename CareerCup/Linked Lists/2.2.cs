//implement an algorithm to find the kth to last element of a singly linked list

//Q: can I assume k is always less than the length of the list  - NO
//Q: is the linked list size known - No

public class Node {
    int val;
    Node next;
    Node(int val = 0, Node next = null) {
        val = val;
        next = next;
    }
}

public class Program {


    public Node kthLastElm(Node head, int k) {
        if (k <= 0) return null;

        Node pointer1 = head;
        Node pointer2 = head;

        int counter = 0;

        while(pointer1 != null) {
            if (pointer1.next == null) { //end reached
                return pointer2;
            } else {
                pointer1 = pointer1.next;
            }

            if (counter >= k) {
                pointer2 = pointer2.next;
            }

            counter++;
        }

        return pointer1;

    }

}