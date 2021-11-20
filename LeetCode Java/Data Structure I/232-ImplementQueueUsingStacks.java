/*
232. Implement Queue using Stacks
mplement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
Implement the MyQueue class:
    void push(int x) Pushes element x to the back of the queue.
    int pop() Removes the element from the front of the queue and returns it.
    int peek() Returns the element at the front of the queue.
    boolean empty() Returns true if the queue is empty, false otherwise.
Notes:
    You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
    Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty(); */
class MyQueue {
    Stack<Integer> s1 = null;
    Stack<Integer> s2 = null;
    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    public void push(int x) { //O(N)
        if (s1.empty()) { //first element push
            s1.push(x);
        } else {
            //push everthing to temp queue, flipping order of elements
            while(!s1.empty()) {
                s2.push(s1.pop());
            }
            s1.push(x); //add newest element to bottom
            //push everything back to s1, now have sudo FIFO with stack
            while(!s2.empty()) {
                s1.push(s2.pop());
            }
        }
    }
    public int pop() { // O(1)
        return s1.pop();
    }
    public int peek() { // O(1)
        return s1.peek();
    }
    public boolean empty() { //O(1)
        if (s1.empty()) {  return true; }
        else { return false; }
    }
}