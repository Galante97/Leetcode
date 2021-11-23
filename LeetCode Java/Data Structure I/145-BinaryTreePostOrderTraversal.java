/*
145. Binary Tree Postorder Traversal

Given the root of a binary tree, return the postorder traversal of its nodes' values.
Example:
    Input: root = [1,null,2,3]
    Output: [3,2,1] 

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> oList = new ArrayList<Integer>();
        
        TraverseTree(root, oList);
        
        return oList;
    }
    
    public void TraverseTree(TreeNode node, List<Integer> oList) {
        if (node == null) {
            return;
        }
        
        TraverseTree(node.left, oList);
        TraverseTree(node.right, oList);
        
        oList.add(node.val);
    }
    
}