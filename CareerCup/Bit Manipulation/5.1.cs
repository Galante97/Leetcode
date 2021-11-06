//you are given two 32-bit numbers, N and M, and two bit positions, i and j
//write a method to insert M into N such that M starts at bit j and ends at bit i
//you can assume that the bits j through i have enough space to fit all of M. That is
//if M = 10011, you can assume that there are at least 5 bits between j and i. You
// would not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2
//Example: 
// input: N = 10000000000, M = 10011, i = 2, j = 6
// output: N = 10001001100

// this problem can be approached in three key steps:
// 1. Clear the bits j through i in N
// 2. shift M so that it lines up with bits j through i
// 3. Merge M and N

public class Solution {


    public int insertBits(int N, int M, int i, int j) {
        /*
        Create a mask to clear bits i through j in N
        EXAMPLE j = 4 i = 2, Result should be 11100011
         */

         int allOnes = ~0; //will equal sequence of all 1s 11111111

         //1s  before position j, then 0s. left = 11100000
         int left = allOnes << (j + 1);

         //1s after position i. right = 00000011
         int right = ((1 << i) - 1);

         //All 1s, except for 0s between i and j. mask - 11100011
         int mask = left || right;

         // clear bits j through i then put m in there
         int n_cleared = N & mask;
         int m_shifted = m << i; //move M into correct postiion

         return n_cleared | m_shifted;
    }

}