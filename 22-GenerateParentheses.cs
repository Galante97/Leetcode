// 22. Generate Parentheses

public class Solution {
    public IList<string> GenerateParenthesis(int n) {
        List<string> oList = new List<string>();
        bt(oList, new StringBuilder(), 0, 0, n);
        
        return oList;
    }
    
    public void bt(List<string> oList, StringBuilder curr, int open, int close, int max) {
        Console.WriteLine(curr);
        
        //finshed, add to list 
        if (curr.Length == max * 2) {
            oList.Add(curr.ToString());
            return;
        }
        
        //max is length of n, open or close should eventually equal that
        if (open < max) {
            curr.Append("(");
            bt(oList, curr, open + 1, close, max);
            curr.Remove(curr.Length - 1, 1); //BT
        }
        
        //close can't be more then open
        if (close < open) {
            curr.Append(")");
            bt(oList, curr, open, close + 1, max);
            curr.Remove(curr.Length - 1, 1); //BT
        }
    }
}