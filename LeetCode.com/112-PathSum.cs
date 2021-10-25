// 112. Path Sum

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
    public bool HasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        
        targetSum -= root.val;
        Console.WriteLine(targetSum);

        if (root.left == null && root.right == null) { //reached leaf
           return (targetSum == 0);
        } else {
            return HasPathSum(root.left, targetSum) || HasPathSum(root.right, targetSum);

        }
        
                    
        
    }
    
}

