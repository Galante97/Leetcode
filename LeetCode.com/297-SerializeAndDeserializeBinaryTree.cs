// 297. Serialize and Deserialize Binary Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public string serialize(TreeNode root) { 
        Queue<TreeNode> q = new Queue<TreeNode>();

        q.Enqueue(root);
        List<int> oList = new List<int>();
        while (q.Any()) {
            TreeNode curr = q.Dequeue();

            if (curr != null) {
                oList.Add(curr.val);
                q.Enqueue(curr.left);
                q.Enqueue(curr.right);
            } else {
                oList.Add(-1001);
            }

        }
        
        //Console.WriteLine(String.Join(",", oList).Replace("-1001","null"));
    
        return String.Join(",", oList).Replace("-1001","null"); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(string data) {
        
        if(data == "null")
            return null;
        
        string[] nodes = data.Split(',' , StringSplitOptions.RemoveEmptyEntries);
        Queue<TreeNode> queue = new Queue<TreeNode>();
        TreeNode root = new TreeNode(int.Parse(nodes[0]));
        queue.Enqueue(root);
        
        for(int i = 1; i < nodes.Length; i++)
        {
            TreeNode curr = queue.Dequeue();
            if(nodes[i] != "null")
            {
                TreeNode left = new TreeNode(Int16.Parse(nodes[i]));
                curr.left = left;
                queue.Enqueue(left);
            }
            
            if(nodes[++i] != "null")
            {
                TreeNode right = new TreeNode(Int16.Parse(nodes[i]));
                curr.right = right;
                queue.Enqueue(right);
            }     
        }
        
        return root;
    
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));