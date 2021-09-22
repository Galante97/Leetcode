//20. Valid Parentheses

public class Solution {
    public bool IsValid(string s) {
        if (s == null || s == string.Empty)
            return true;
        
        Dictionary<char, char> dict = new Dictionary<char, char>();
        Stack<char> stack = new Stack<char>();
        
        dict.Add(')', '(');
        dict.Add('}', '{');
        dict.Add(']', '[');
        
        foreach (var c in s)
            if (c == ')' || c == '}' || c == ']')
            {
                if (stack.Count > 0 && stack.Peek() == dict[c])
                    stack.Pop();
                else
                    return false;
            }
            else
                stack.Push(c);
        
        return stack.Count == 0;
        
    }
}