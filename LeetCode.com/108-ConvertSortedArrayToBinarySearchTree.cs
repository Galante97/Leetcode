//108. Convert Sorted Array to Binary Search Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
  int[] nums;
    
  public TreeNode SortedArrayToBST(int[] nums) {
    this.nums = nums;
    return helper(0, nums.Length - 1);
  }

  public TreeNode helper(int left, int right) {
    if (left > right) return null;

    // always choose left middle node as a root
    int mid = (left + right) / 2;

    // preorder traversal: node -> left -> right
    TreeNode root = new TreeNode(nums[mid]);
    root.left = helper(left, mid - 1);
    root.right = helper(mid + 1, right);
    return root;
  }


}