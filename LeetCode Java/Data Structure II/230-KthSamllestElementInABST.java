/*
 * 230. Kth Smallest Element in a BST
 * Given the root of a binary search tree, and an integer k, return the kth
 * smallest value (1-indexed) of all the values of the nodes in the tree.
 * Example:
    * Input: root = [5,3,6,2,4,null,null,1], k = 3
    * Output: 3
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
    // ime complexity : O(N) to build a traversal.
    // Space complexity : O(N) to keep an inorder traversal.
    List<Integer> values = new ArrayList<Integer>();

    public int kthSmallest(TreeNode root, int k) {
        TraverseInOrder(root);
        return values.get(k - 1);

    }

    // Inorder traversal and add to lists of BST will return an ordered list
    public void TraverseInOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        TraverseInOrder(node.left);
        values.add(node.val);
        TraverseInOrder(node.right);
    }
}