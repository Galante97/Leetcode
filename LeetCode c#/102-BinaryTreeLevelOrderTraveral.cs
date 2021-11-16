//102. Binary Tree Level Order Traversal

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
    public IList<IList<int>> LevelOrder(TreeNode root) {
       var oList = new List<IList<int>>();
        
        if (root == null) return oList;
        oList.Add(new List<int>() {root.val});
        
        TraverseTree(root.left, oList);
        TraverseTree(root.right, oList);
        
        return oList;
    }
    
    public void TraverseTree(TreeNode node, IList<IList<int>> oList, int depth = 0) {
        if (node == null) return;
        if (oList.Count == ++depth) oList.Add(new List<int>());
        
        Console.WriteLine(depth);
        
        oList[depth].Add(node.val);
        
        TraverseTree(node.left, oList, depth);
        TraverseTree(node.right, oList, depth);
                
    }
    
    
    
}