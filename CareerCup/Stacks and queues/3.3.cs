// imagine a literal stack of plates. If the stack is too high in my topple. Therefore in real life we would likely start a new stack when the previous stack exceeds some threshold.
// Implement a data structure set of stacks that mimics this. Set of stacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity. 
// SetofStacks.push() and SetofStacks.pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack).
//follow up: implement a function popAt(int index) which performs a pop operationn at a specific sub-stack index.

//Q: how high is each stack of plates? - 10
//Q: what are the stacks holding - ints
public class SetofStacks
{
    public int maxStackSize;
    public List<Stack<int>> stacksList = new List<Stack<int>>();

    SetofStacks(int _maxStackSize)
    {
        maxStackSize = _maxStackSize;
    }

    public void Push(int v)
    {
        var last = stacksList.Last();

        if (last.Count() >= maxStackSize)
        { //stack is full, create new stack
            Stack<int> stack = new Stack<int>(); //create new
            stack.Push(v); //push current
            stacksList.Add(stack); //add to list

        }
        else
        { //add to existing stack 
            last.Push(v);
        }
    }
    public int Pop()
    {
        var last = stacksList.Last();

        if (last.Count() == 1)
        {
            stacksList.RemoveAt(stacksList.Count() - 1);
            return last.Pop();
        }
        else
        {
            return last.Pop();
        }

    }
}
