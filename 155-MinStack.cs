//155. Min Stack
public class MinStack {
    private Stack<(int Value, int Min)> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<(int, int)>();
    }
    
    public void Push(int val) {
        var min = stack.Any() ? Math.Min(val, GetMin()) : val;
        stack.Push(new ValueTuple<int, int>(val, min));
    }
    
    public void Pop() {
        stack.Pop();
    }
    
    public int Top() {
        return (int)stack.Peek().Value;
    }
    
    public int GetMin() {
        return stack.Peek().Min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.Push(val);
 * obj.Pop();
 * int param_3 = obj.Top();
 * int param_4 = obj.GetMin();
 */