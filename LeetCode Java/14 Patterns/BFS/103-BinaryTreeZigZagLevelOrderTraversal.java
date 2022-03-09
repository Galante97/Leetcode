/*
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal of
 * its nodes' values. (i.e., from left to right, then right to left for the next
 * level and alternate between).
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        q.add(root);

        boolean revFlag = false;

        while (!q.isEmpty()) {
            var size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                var curr = q.remove();
                level.add(curr.val);
                if (curr.left != null) { q.add(curr.left); }
                if (curr.right != null) { q.add(curr.right); }
            }
            if (revFlag) {
                Collections.reverse(level);
                revFlag = false;
            } else {
                revFlag = true;
            }
            res.add(level);
        }
        return res;
    }
}