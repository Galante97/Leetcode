/* 103. Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal of
 * its nodes' values. (i.e., from left to right, then right to left for the next
 * level and alternate between).
 * Example 1:
    * Input: root = [3,9,20,null,null,15,7]
    * Output: [[3],[20,9],[15,7]]
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
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Create a double list as output
        List<List<Integer>> oList = new ArrayList<List<Integer>>();
        if (root == null)
            return oList;
        // create a queue
        Queue<TreeNode> q = new LinkedList<>();
        // enqueue the root
        q.add(root);
        int rowNum = 0;
        // while is not empty iterate
        while (!q.isEmpty()) {
            // get count of q (thats how many nodes on current row)
            int nodeCount = q.size();
            List<Integer> currRow = new ArrayList<Integer>();
            for (int i = 0; i < nodeCount; i++) {
                TreeNode currNode = q.remove();
                currRow.add(currNode.val);
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
            if (rowNum % 2 == 1) {
                Collections.reverse(currRow);
            }
            oList.add(currRow);
            rowNum++;
        }
        return oList;
    }
}