// 117. Populating Next Right Pointers in Each Node II

/*
// Definition for a Node.
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
*/

public class Solution {
    public Node Connect(Node root) {
        if(root == null) return root;
        
        Queue<Node> q = new Queue<Node>();
        q.Enqueue(root);
        while(q.Count != 0) {
            List<Node> level = new List<Node>();
            int size = q.Count;
            for(int i = 0; i < size; i++) {
                Node curr = q.Dequeue();
                level.Add(curr);
                
                if(curr.right != null) q.Enqueue(curr.right);
                if(curr.left != null) q.Enqueue(curr.left);
            }
            //[3, 2]  count = 1 
            for(int i = level.Count - 1; i >= 1; i--) {
                level[i].next = level[i - 1];
            }
        }
        return root;
    }
    
}