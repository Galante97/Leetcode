/*
 * 637. Average of Levels in Binary Tree
 * Given the root of a binary tree, return the average value of the nodes on
 * each level in the form of an array. Answers within 10-5 of the actual answer
 * will be accepted.
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [3.00000,14.50000,11.00000]
 * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5,
 * and on level 2 is 11.
 * Hence return [3, 14.5, 11].
 */

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Double sum = 0.00;
            int count = 0;
            Queue<TreeNode> temp = new LinkedList<>();

            while (!q.isEmpty()) {
                var curr = q.remove();
                if (curr.left != null) {
                    temp.add(curr.left);
                }
                if (curr.right != null) {
                    temp.add(curr.right);
                }
                System.out.println(curr.val);
                sum += curr.val;
                count++;
            }
            res.add(sum / count);
            q = temp;
        }
        return res;
    }
}