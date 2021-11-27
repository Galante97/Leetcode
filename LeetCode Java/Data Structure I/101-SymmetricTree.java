/*
101. Symmetric Tree
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
Example:
    Input: root = [1,2,2,3,4,4,3]
    Output: true
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    //Time complexity : O(n). Because we traverse the entire input tree once
    //Space complexity : The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in O(n)

    public boolean isSymmetric(TreeNode root) {
         return TraverseTree(root.left, root.right);
    }
    
    public boolean TraverseTree(TreeNode t1, TreeNode t2) {        
        if (t1 == null && t2 == null) { return true; }
        if (t1 == null || t2 == null) { return false; }
        
        //if not a leaf keep traversing
        return (t1.val == t2.val) &&
                TraverseTree(t1.left, t2.right) &&
                TraverseTree(t1.right, t2.left);
        
    }   
    
}