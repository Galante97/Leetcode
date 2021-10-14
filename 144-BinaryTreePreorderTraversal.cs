//144. Binary Tree Preorder Traversal

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
    public IList<int> PreorderTraversal(TreeNode root) {
        var oList = new List<int>();
             
        TraverseTree(root, oList);
                    
        return oList;
        
    }
    
    void TraverseTree(TreeNode node, List<int> oList) {
        if (node == null) return;
        
        oList.Add(node.val);
        
        TraverseTree(node.left, oList);
        TraverseTree(node.right, oList);
        
    }
}