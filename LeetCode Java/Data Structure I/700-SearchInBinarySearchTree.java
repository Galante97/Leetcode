/*
700. Search in a Binary Search Tree
You are given the root of a binary search tree (BST) and an integer val.

Find the node in the BST that the node's value equals val and return the 
subtree rooted with that node. If such a node does not exist, return null.
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
    //Time complexity : O(H), where H is a tree height. That results in O(logN) in the average case, and O(N) in the worst case.
    //Space complexity : O(H), where H is a tree height. That results in O(logN) in the average case, and O(N) in the worst case.
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        //Binary Search
        if (val < root.val) {
            return searchBST(root.left, val);
        } else{
            return searchBST(root.right, val);  
        }
    }
}