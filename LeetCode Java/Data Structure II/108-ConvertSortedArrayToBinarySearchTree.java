/*
 * 108. Convert Sorted Array to Binary Search Tree
 * Given an integer array nums where the elements are sorted in ascending order,
 * convert it to a height-balanced binary search tree.
 * 
 * A height-balanced binary tree is a binary tree in which the depth of the two
 * subtrees of every node never differs by more than one.
 * 
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
    // Time complexity: O(N) since we visit each node exactly once.
    // Space complexity: O(\log N)O(logN).
    // The recursion stack requires O(logN) space because the tree is
    // height-balanced. Note that the O(N) space used to store the output does not
    // count as auxiliary space, so it is not included in the space complexity.

    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        // send in first and last index
        return helper(0, nums.length - 1);
    }
    public TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        // find mid point (index)
        int mid = (left + right) / 2;
        // preorder traversal: node -> left -> right
        // new treeNode with mid point (value)
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(left, mid - 1);
        root.right = helper(mid + 1, right);
        return root;
    }
}