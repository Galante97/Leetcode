/*
653. Two Sum IV - Input is a BST
Given the root of a Binary Search Tree and a target number k, return true 
if there exist two elements in the BST such that their sum is equal to the given target.
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
    //Time complexity : O(n). The entire tree is traversed only once in the worst case. Here, nn refers to the number of nodes in the given tree.
    //Space complexity : O(n). The size of the setset can grow upto nn in the worst case.
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<Integer>();
        return find(root, k, set);
    }
    
    public boolean find(TreeNode node, int k, HashSet<Integer> set) {
        if (node == null) {
            return false;
        }
        
        if (set.contains(k - node.val)) {
            return true;
        }
        
        set.add(node.val);
        
        return find(node.left, k, set) || find(node.right, k, set);
        
    }
}