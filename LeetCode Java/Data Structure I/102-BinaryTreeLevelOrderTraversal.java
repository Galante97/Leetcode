/*
102. Binary Tree Level Order Traversal
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
Example:
    Input: root = [3,9,20,null,null,15,7]
    Output: [[3],[9,20],[15,7]]
*/
/** Definition for a binary tree node.
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
 * } */
class Solution {
    // Time complexity : O(N) since each node is processed exactly once.
    // Space complexity : O(N) to keep the output structure which contains N node values.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if (root == null) return output;
       
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while(q.size() > 0) {
            List<Integer> currLevel = new ArrayList<Integer>();
            var qSize = q.size(); //can change in the loop so save before
            for (int i=0; i<qSize; i++) { 
                var node = q.remove();
                
                // fulfill the current level
                currLevel.add(node.val);

                // add child nodes of the current level
                // in the queue for the next level
                if (node.left != null) { q.add(node.left); }
                if (node.right != null) { q.add(node.right); }
            }
            
            output.add(currLevel);
        }
         return output;
    }
}