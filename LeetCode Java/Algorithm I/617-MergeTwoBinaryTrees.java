/*
 * 617. Merge Two Binary Trees
 * You are given two binary trees root1 and root2.
 * 
 * Imagine that when you put one of them to cover the other, some nodes of the
 * two trees are overlapped while the others are not. You need to merge the two
 * trees into a new binary tree. The merge rule is that if two nodes overlap,
 * then sum node values up as the new value of the merged node. Otherwise, the
 * NOT null node will be used as the node of the new tree.
 * 
 * Return the merged tree.
 * Note: The merging process must start from the root nodes of both trees.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    // Time complexity : O(m). A total of mm nodes need to be traversed. Here, mm
    // represents the minimum number of nodes from the two given trees.
    // Space complexity : O(m). The depth of the recursion tree can go upto mm in
    // the case of a skewed tree. In average case, depth will be O(logm).
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        TreeNode sum = new TreeNode();

        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) { // no addition return this node
            return root2;

        } else if (root2 == null) { // no addition return this node
            return root1;

        } else { // merge nodes
            sum.val = root1.val + root2.val;
            sum.left = mergeTrees(root1.left, root2.left);
            sum.right = mergeTrees(root1.right, root2.right);
        }
        return sum;
    }
}