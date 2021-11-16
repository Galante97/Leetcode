//235. Lowest Common Ancestor of a Binary Search Tree

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
    private TreeNode LCA = null;
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Value of current node or parent node.
        int parentVal = root.val;
        
        if (p.val > parentVal && q.val > parentVal) {
            // If both p and q are greater than parent
            return LowestCommonAncestor(root.right, p, q);
        } else if (p.val < parentVal && q.val < parentVal) {
            // If both p and q are lesser than parent
            return LowestCommonAncestor(root.left, p, q);
        } else {
            //ANCESTOR WILL ALWAYS BE BETWEEN P AND Q
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
    
}