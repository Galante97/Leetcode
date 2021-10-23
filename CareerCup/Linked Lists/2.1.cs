//Write code to remove duplicates from an unsorted linked lists
//FOLLOW UP - how would u solve this problem if a tempeary buffer is not allowed?

//Q: i asssume the value in the the node cannot be null - yes 
//Q: i assume singly linked list

public class Node {
      public int val;
      public Node next;
      public Node(int val=0, Node next=null) {
          this.val = val;
          this.next = next;
    }
}

public class Program {
    public Node RemoveDuplicates(Node n) {
        hashSet<int> set = new HashSet<int>();
        Node head = n;
        Node prev = null;

        while(n != null) {
            if (set.Contains(n.val)) {
                //duplicate found, skip it
                prev.next = n.next;
            } else {
                set.Add(n.val);
                prev = n;
            }
        }

        return head;
    }

}

