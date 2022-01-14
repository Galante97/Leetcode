/*
 * 231. Power of Two
 * 
 * Given an integer n, return true if it is a power of two. Otherwise, return
 * false.
 * An integer n is a power of two, if there exists an integer x such that n ==
 * 2x.
 * 
 * Example 1:
 * Input: n = 1
 * Output: true
 * Explanation: 20 = 1
 * 
 */
class Solution {
    // The idea behind both solutions will be the same: a power of two in binary
    // representation is one 1-bit, followed by some zeros:
    // 1 = (0000 0001)
    // 2 = (0000 0010)
    // 4 = (0000 0100)
    // 8 = (0000 1000)

    // Time complexity : O(1).
    // space complexity : O(1).

    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        long x = (long) n;
        // two's compliment
        return (x & (-x)) == x;
    }
}