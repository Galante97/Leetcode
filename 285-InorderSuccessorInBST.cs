//285. Inorder Successor in BST


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    List<TreeNode> oList = new List<TreeNode>();

    public TreeNode InorderSuccessor(TreeNode root, TreeNode p) {
         
        TraversInOrder(root, p);
        
        //Console.WriteLine(String.Join(", ", oList)); 

        int index = oList.FindIndex(a => a == p);
        
        if (index+1 < oList.Count()) {
            return oList[index+1];
        } else {
            return null;
        }
        
    }
    
        public void TraversInOrder(TreeNode node, TreeNode k) {
        if (node == null)
            return;

        TraversInOrder(node.left, k);
        oList.Add(node);
        TraversInOrder(node.right, k);
    }

}

