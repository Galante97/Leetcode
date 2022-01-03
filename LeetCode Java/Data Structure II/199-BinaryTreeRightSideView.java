/*
 * 199. Binary Tree Right Side View
 * Given the root of a binary tree, imagine yourself standing on the right side
 * of it, return the values of the nodes you can see ordered from top to bottom.
 * Example 1:
    * Input: root = [1,2,3,null,5,null,4]
    * Output: [1,3,4]
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
    public List<Integer> rightSideView(TreeNode root) {
        // Initialize output list
        List<Integer> oList = new ArrayList<Integer>();
        if (root == null) {
            return oList;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int nodeCount = q.size();
            for (int i = 1; i <= nodeCount; i++) {
                TreeNode currNode = q.remove(); // dequeue
                if (i == nodeCount) {
                    oList.add(currNode.val);
                }
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
        return oList;
    }
}