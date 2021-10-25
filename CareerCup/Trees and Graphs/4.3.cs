// 4.3 Given a sorted (increasing order) array with unique integer elements, 
// write an algorithm to create a binary search tree with minimal hight

// solution so they want a balanced binary search tree 

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

public class Program {


    public TreeNode GenerateMinTree(int[] arr) {
        if (arr.Length == 0) return null;
        if (arr.Length == 1) return new TreeNode(arr[0]);

        
        return generateTree(arr, 0, arr.Length - 1);

    }

    public TreeNode generateTree(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        //get middle
        int mid = (start + end) / 2;

        //create new tree
        TreeNode Tree = new TreeNode(arr[mid]);

        //iterate and repeat
        Tree.left = GenerateTree(arr, start, mid - 1);
        Tree.right = GenerateTree(arr, mid + 1, end);

        return Tree;



        
    }



}