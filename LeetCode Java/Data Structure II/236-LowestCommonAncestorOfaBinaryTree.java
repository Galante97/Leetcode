/*
 * 236. Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(N)

    private TreeNode LCA = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverseTree(root, p, q);
        return LCA;
    }

    public boolean traverseTree(TreeNode currNode, TreeNode p, TreeNode q) {
        // If reached the end of a branch, return false.
        if (currNode == null) {
            return false;
        }
        int foundCount = 0;
        // traverse left
        if (traverseTree(currNode.left, p, q)) { foundCount++;}
        // traverse right
        if (traverseTree(currNode.right, p, q)) {  foundCount++; }
        // traverse middle, i.e current node
        if (currNode == p || currNode == q) { foundCount++; }
        // If any two of the flags left, right or mid become True
        if (foundCount >= 2) { LCA = currNode; }
        
        return (foundCount > 0);
    }
}