// 145. Binary Tree Postorder Traversal

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
    public IList<int> PostorderTraversal(TreeNode root) {
        var oList = new List<int>();
        
        TT(root, oList);
        
        return oList;
    }
    
    void TT(TreeNode node, List<int> oList) {
        if (node == null) return;
        
        TT(node.left, oList);
        TT(node.right, oList);
        
        oList.Add(node.val);
        
        
    }
}