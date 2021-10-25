// 701. Insert into a Binary Search Tree

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
    public TreeNode InsertIntoBST(TreeNode root, int val) {
        //insert at leaf
        if (root == null) { return new TreeNode(val); }
             
         // insert into the left subtree
        if (val < root.val) {
            root.left = InsertIntoBST(root.left, val);
        
        // insert into the right subtree
        } else {
            root.right = InsertIntoBST(root.right, val);
        }
        
        return root;

    }
}