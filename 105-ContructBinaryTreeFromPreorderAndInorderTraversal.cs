//105. Construct Binary Tree from Preorder and Inorder Traversal

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
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.Length == 0 || inorder == null || inorder.Length == 0)
            return null;
        
        return BuildTree(preorder, 0, preorder.Length - 1, inorder, 0, inorder.Length - 1);
    }
    
    private TreeNode BuildTree(int[] preorder, int i, int j, int[] inorder, int k, int l)
    {
        if (i > j || k > l)
            return null;
        
        TreeNode node = new TreeNode(preorder[i]);
        
        if (i != j)
        {
            int m = k;
            
            for (; m < inorder.Length; m++)
                if (inorder[m] == preorder[i])
                    break;
            
            node.left = BuildTree(preorder, i + 1, i + m - k, inorder, k, m - 1);
            node.right = BuildTree(preorder, i + 1 + m - k, j, inorder, m + 1, l );
        }
        
        return node;
    }
}
    
    
    
