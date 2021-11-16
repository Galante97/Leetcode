// 1214. Two Sum BSTs

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
public class Solution {
    bool match = false;
    HashSet<int> map = new HashSet<int>();

    public bool TwoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        
        TraverseTree(root1, true, target);
        TraverseTree(root2, false, target);
        
        return match;
    }
    
    public void TraverseTree(TreeNode node, bool isFirstTree,int target) {
        if (node == null) return;
        
        
        if (isFirstTree) {
            map.Add(node.val);
        } else {
            if (map.Contains(target - node.val)) {
                match = true;
                return;
            }
        }
        
        TraverseTree(node.left, isFirstTree, target);
        TraverseTree(node.right, isFirstTree, target);
    }
    
    
}