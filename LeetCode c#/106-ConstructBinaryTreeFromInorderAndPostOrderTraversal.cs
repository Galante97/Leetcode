// 106. Construct Binary Tree from Inorder and Postorder Traversal
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
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
      return DFS(inorder, 0, inorder.Length - 1, postorder, 0, postorder.Length - 1);

    }
    
TreeNode DFS(int[] inOrder, int inLeft, int inRight, int[] postOrder, int postLeft, int postRight) {
    if (postLeft > postRight) { //subtree is empty return null
        return null; 
    }

    //current "root" is last element in post order traversal
    var currVal = postOrder[postRight]; 
    
    
    var count = 0;
    var i = inLeft;
    
    while (i <= inRight) {
        if (inOrder[i] == currVal) {
            break;
        }
        i++;
        count++;
    }

    var cur = new TreeNode(currVal);
    cur.left = DFS(inOrder, inLeft, i - 1, postOrder, postLeft, postLeft + count - 1);
    cur.right = DFS(inOrder, i + 1, inRight, postOrder, postLeft + count, postRight - 1);

    return cur;

}
        
        
        
        
}