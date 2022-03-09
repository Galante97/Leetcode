/*
 * 111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the
 * root node down to the nearest leaf node.
 * 
 * Note: A leaf is a node with no children.
 * Example 1:
    * Input: root = [3,9,20,null,null,15,7]
    * Output: 2
 */

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int depth = 1;

        while (!q.isEmpty()) {
            var size = q.size();

            for (int i = 0; i < size; i++) {
                var curr = q.remove();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }

                if (curr.left == null && curr.right == null) {
                    return depth;
                }
            }
            depth++;
        }
        return depth;
    }
}