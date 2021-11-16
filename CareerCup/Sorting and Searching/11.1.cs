// 11.1 you are given two sorted arrays A and B, where A has a large enough
// buffer at the end to hold B. Write a method to merge B into A in sorted order

// Q merge in place - yes
// how long or short can A be - 0, 100000
// holds ints - yes

public class Program
{

    public int[] A = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    public int[] B = new int[] { 3, 4, 7, 8, 9, 10, 12, 15, 19, 25, 40, 59, 70 };

    public int[] MergeArrays(int[] a, int[] b)
    {
        if (a.Length <= 0)
        {
            return b;
        }

        if (b.Length <= 0)
        {
            return a;
        }

        if (a.Length <= 0 && b.Length <= 0)
        {
            return new int[] { };
        }

        var A_pointer = a.Length - b.Length - 1;
        var B_pointer = b.Length - 1;

        for (int i = a.Length - 1; i >= 0; i--)
        {
            if (B_pointer < 0)
            {
                break;
            }

            if (a[A_pointer] >= b[B_pointer])
            {
                a[i] = a[A_pointer];
                a[A_pointer] = -1;
                A_pointer--;
            }
            else
            {
                a[i] = b[B_pointer];
                B_pointer--;
            }
        }

        return a;
    }


}