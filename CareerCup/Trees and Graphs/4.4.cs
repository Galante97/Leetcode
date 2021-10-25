//4.4 - Given  Binary tree deisgn a algorithm which creates a linked list of all nodes at each 
// depth (e.g. if you have a tree with depth D, you will have D linked lists)

//Q: assume signly linked lists - YES

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

public class ListNode
{
    public ListNode next;
    public int val;
    public ListNode(int _val = 0, ListNode _next = null)
    {
        next = _next;
        val = _val;
    }
}

public class Program
{
    List<ListNode> LinkedLists = new List<ListNode>();
    public List<ListNode> CreateLinkedLists(TreeNode root) {
        //BFS algo
        Queue<TreeNode> q = new Queue<TreeNode>();
        q.Enqueue(root);

        while (q.Count() > 0) {
            int size = q.Count();

            ListNode LL = null;
            ListNode head = null;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.Dequeue();

                if (LL == null) { //new LL
                    LL = new ListNode(curr.val);
                    head = LL;
                }
                else {
                    LL.next = new ListNode(curr.val);
                    LL = LL.next;
                }
                if (curr.left != null) q.Enqueue(curr.left);
                if (curr.right != null) q.Enqueue(curr.right);
            }

            LinkedLists.Add(head);

        }

        return LinkedLists;
    }


}