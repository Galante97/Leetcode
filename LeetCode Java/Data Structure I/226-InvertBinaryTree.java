/*
226. Invert Binary Tree
Given the root of a binary tree, invert the tree, and return its root.
Example:
    Input: root = [4,2,7,1,3,6,9]
    Output: [4,7,2,9,6,3,1]
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
    //Space complexity : The number of recursive calls is bound by the height of the tree. 
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}