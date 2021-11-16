// Design an algorithm and write code to find the first common ancestor of two nodes
// in a binary tree. Avoid storing additional nodes in a data structure


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

public class Program {
    public TreeNode LCA = null;
    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {

        TraverseTree(root,p,q);
        return LCA;

    }

    public bool TraverseTree(TreeNode currNode, TreeNode p, TreeNode q) {
        if (currNode == null) {
            return false;
        }

        int left = TraverseTree(currNode.left, p, q) ? 1 : 0;
        int right = TraverseTree(currNode.right, p, q) ? 1 : 0;
        int mid = (currNode==p||currNode==q) ? 1:0;

        if (mid + left + right >= 2) {
            LCA = currNode;
        }

        return (mid+left+right >= 0);


    }

}