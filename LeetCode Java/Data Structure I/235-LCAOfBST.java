/*
235. Lowest Common Ancestor of a Binary Search Tree
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between
 two nodes p and q as the lowest node in T that has both p and q as descendants 
 (where we allow a node to be a descendant of itself).”
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    //Time Complexity: O(N), where N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
    //Space Complexity: OO(N). This is because the maximum amount of space utilized by the recursion stack would be N since the height of a skewed BST could be N.
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Value of current node or parent node.
        int parentVal = root.val;
        
        if (p.val > parentVal && q.val > parentVal) { //below
            // If both p and q are greater than parent
            return lowestCommonAncestor(root.right, p, q);
        } else if (p.val < parentVal && q.val < parentVal) { //above
            // If both p and q are less than parent
            return lowestCommonAncestor(root.left, p, q);
        } else { //inbetween
            //ANCESTOR WILL ALWAYS BE BETWEEN P AND Q
            // We have found the split point, i.e. the LCA node.
            return root;
        }
    }
}