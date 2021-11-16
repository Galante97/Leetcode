//116. Populating Next Right Pointers in Each Node

public class Solution {
    public Node Connect(Node root) {
      if(root == null) return null;
      
      if(root.left != null) 
          root.left.next = root.right;
      if(root.right != null && root.next != null)
          root.right.next = root.next.left;
      
      Connect(root.left);
      Connect(root.right);
      
      return root;
    }
}