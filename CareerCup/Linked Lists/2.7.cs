//Implement a function to check if a linked list is a palindrome

//Q: do they hold ints, chars? characters
//Q: can a character be emtpy - no


public class Program
{


    public bool isPalindrome(LinkedList<char> lst)
    {
        LinkedListNode<char> fast = lst.First;
        LinkedListNode<char> slow = lst.First;

        Stack<char> revStack = new Stack<char>();

        int counter = 0;

        while (fast.Next != null)
        {

            fast = fast.Next;
            if (counter % 2 == 0)
            {
                revStack.Push(slow.Value);
                slow = slow.Next;
            }

            counter++;
        }

        if (counter % 2 == 0)
        {
            revStack.Push(slow.Value);
        }

        PrintStack(revStack);

        while (slow.Next != null)
        {
            if (revStack.Pop() != slow.Value)
            {
                return false;
            }
            slow = slow.Next;
        }

        return true;

    }

}