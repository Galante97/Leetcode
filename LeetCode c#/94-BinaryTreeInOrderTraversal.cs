//94. Binary Tree Inorder Traversal


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    
    IList<int> oList = new List<int>();
    
    public IList<int> InorderTraversal(TreeNode root) {

        TraversInOrder(root);
        return oList;
    }
    
    
    public void TraversInOrder(TreeNode node) {
        if (node == null)
            return;
 
        /* first recur on left child */
        TraversInOrder(node.left);
 
        /* then print the data of node */
        oList.Add(node.val);
        
        /* now recur on right child */
        TraversInOrder(node.right);
    }
    
}