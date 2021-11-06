//implement a function to see if a binary tree is a binary search tree 


public class TreeNode
{
    public TreeNode left, right;
    public int val;
    TreeNode(int _val = 0, TreeNode _left = null, TreeNode _right = null)
    {
        left = _left;
        right = _right;
        val = _val;
    }
}
public class Solution
{
    public bool IsValidBST(TreeNode root)
    {
        if (root == null)
        {
            return true;
        }

        return TraverseInOrder(root, null, null);
    }

    public bool TraverseInOrder(TreeNode node, int? low, int? high)
    {
        if (node == null)
        {
            return true;
        }

        if ((low != null && node.val <= low) || (high != null && node.val >= high))
        {
            return false;
        }


        return TraverseInOrder(node.left, low, node.val) && TraverseInOrder(node.right, node.val, high);
    }

} 