//2.3 implement an algorithm to delete  NODE IN THE MIDDLE OF A SINGLY LINKED LIST, GIVEN ONLY access to that node 
//example given node c - input: a->b->c->d->e
//example (nothing returned) output: a->b->d->e

//Q: can I assume there is always a node before and after the given node? - YES

//solution copy the next node to current and delete next

public class Node {
    public int val; 
    public Node next;
    Node(int val = 0, Node next = null) {
        val = val;
        next = next;
    }

}

public class Program { 

    public void DeleteCurrentNode(Node node) {
        //null node
        if (node == null) return;

        //in the middle or beginning of linked list
        if (node.next != null) {
            node.val = node.next.val;
            if (node.next.next != null) {
                node.next = node.next.next;
            } else { //2 over was null 
                node.next = null;
            }
        } else { //must be end of list, set current to null
            node = null; //removes node
        }

    }

}
