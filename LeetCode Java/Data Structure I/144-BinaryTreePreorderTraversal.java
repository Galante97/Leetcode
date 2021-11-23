/*
144. Binary Tree Preorder Traversal
Given the root of a binary tree, return the preorder traversal of its nodes' values.

Example:
    Input: root = [1,null,2,3]
    Output: [1,2,3]
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
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> oList = new ArrayList<Integer>();

        TraverseTree(root, oList);
        return oList;
    }
    
    public void TraverseTree(TreeNode node, List<Integer> oList) {
        if (node == null) {
            return;
        }
        
        oList.add(node.val);
        TraverseTree(node.left, oList);
        TraverseTree(node.right, oList);
        
    }
}