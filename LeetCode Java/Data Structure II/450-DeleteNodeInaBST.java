/*
 * 450. Delete Node in a BST
 * Given a root node reference of a BST and a key, delete the node with the
 * given key in the BST. Return the root node reference (possibly updated) of
 * the BST.
 * 
 * Basically, the deletion can be divided into two stages:
    * Search for a node to remove.
    * If the node is found, delete the node.
 */

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) { return null;}
        // Binary search
        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else { // delete node found
            // node is a leaf
            if (root.left == null && root.right == null) {
                root = null;
            } else if (root.right != null) { // the node is not a leaf and has a right child
                root.val = Successor(root);
                root.right = deleteNode(root.right, root.val);
            } else { // the node is not a leaf, has no right child, and has a left child
                root.val = Predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
    // One step right and then always left
    public int Successor(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }
    // One step left and then always right
    int Predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null)
            root = root.right;
        return root.val;
    }
}
