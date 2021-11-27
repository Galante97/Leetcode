/* 104. Maximum Depth of Binary Tree
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
Example:
    Input: root = [3,9,20,null,null,15,7]
    Output: 3
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
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
    
    public int maxDepth(TreeNode node, int depth) {
        if (node == null) { return depth; }
        
        depth++;
        int left = maxDepth(node.left, depth);
        int right = maxDepth(node.right, depth);
        
        return Math.max(left, right);
        
    }
}