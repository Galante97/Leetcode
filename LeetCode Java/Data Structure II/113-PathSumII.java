/*
 * 113. Path Sum II
 * Given the root of a binary tree and an integer targetSum, return all
 * root-to-leaf paths where the sum of the node values in the path equals
 * targetSum. Each path should be returned as a list of the node values, not
 * node references.
 * 
 * A root-to-leaf path is a path starting from the root and ending at any leaf
 * node. A leaf is a node with no children.
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
    List<List<Integer>> oList = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        TraverseTree(root, new ArrayList<Integer>(), 0, targetSum);
        return oList;
    }

    public void TraverseTree(TreeNode node, List<Integer> nodeList, int total, int targetSum) {
        if (node == null) {
            return;
        }
        total += node.val;
        nodeList.add(node.val);

        if (node.left == null && node.right == null && total == targetSum) {
            oList.add(new ArrayList(nodeList));
        } else {
            TraverseTree(node.left, nodeList, total, targetSum);
            TraverseTree(node.right, nodeList, total, targetSum);
        }
        // backtracking
        nodeList.remove(nodeList.size() - 1);
    }
}
