
//Implement a MyQueue class which implements a queue using two stacks

//Q: can I assume neither stack is null - NO
//Q : what objects to the stacks hold - ints
//Q: does it matter the order in which the items in the stack are added to the queue - no
public class MyQueue
{
    public Stack<int> s1;
    public Stack<int> s2;

    public Queue<int> queue;

    MyQueue(Stack<int> _s1, Stack<int> _s2)
    {
        s1 = _s1;
        s2 = _s2;

        queue = CreateQueue();
    }

    Queue<int> CreateQueue()
    {
        var queue = new Queue<int>();

        int size = Math.Max(s1.Count(), s2.Count());

        for (int i = 0; i < size; i++)
        {
            if (s1.Count() != 0)
            {
                queue.Enqueue(s1.Pop());
            }

            if (s2.Count != 0)
            {
                queue.Enqueue(s2.Pop());

            }
        }

        return queue;

    }


}