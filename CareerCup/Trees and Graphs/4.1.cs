// Implement a function to check if a binary tree is balanced.
// for the purposes of this question, a balanced tree is defined to be a tree such that 
// the heights of the two subtrees of any node never differ by more than one node

//what is the max number of nodes in the tree 1000

public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class program {

    bool balanced = true;
    public bool isTreeBalanced(TreeNode root) {
        if (root == null) return true;

        InOrderTraversal(root, 0);

        return balanced;
    }

    public int InOrderTraversal(TreeNode node) {
        if (node == null) return -1;

        //leaf reached
        int left = InOrderTraversal(node.left);
        int right = InOrderTraversal(node.right);

        if (Math.Abs(left-right) > 1) {
            balanced = false;
            return -1;
        }

        return Math.Max(left, right) + 1;

    }
}