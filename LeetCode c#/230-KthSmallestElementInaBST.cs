//230. Kth Smallest Element in a BST

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
    List<int> oList = new List<int>();
    
    public int KthSmallest(TreeNode root, int k) {
 
        TraversInOrder(root, k);
        
        return oList[k - 1];
        
    }

    public void TraversInOrder(TreeNode node, int k) {
        if (node == null)
            return;

        TraversInOrder(node.left, k);
        oList.Add(node.val);
        TraversInOrder(node.right, k);
    }


}