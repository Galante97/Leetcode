//Write a program to sort a stack in ascending order.
// you may yse at most one additional stack to hold items, but you may not copy the elements into any other data structures.
//the stack supports the following operations: push, pop, isEmpty


public class program {

    public Stack<int> SortStack(Stack<int> s1) {
        Stack<int> s2 = new Stack<int>();

        while(!s1.IsEmpty()) {
            int tmp = s1.Pop(); //step 1
            while(!s2.IsEmpty() && tmp > s2.Peek()) { //step 2
                s1.Push(s2.Pop());
            }

            s2.Push(temp); //step 3
        }

        return s2;


    }
}