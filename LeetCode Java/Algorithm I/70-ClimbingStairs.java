/*
 * 70. Climbing Stairs
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can
 * you climb to the top?
 * 
 * Example 1:
    * Input: n = 2
    * Output: 2
    * Explanation: There are two ways to climb to the top.
    * 1. 1 step + 1 step
    * 2. 2 steps
 */
class Solution {
    // Time complexity : O(n). Single loop up to nn is required to calculate n^th
    // fibonacci number.
    // Space complexity : O(1). Constant space is used.
    public int climbStairs(int n) {
        if (n == 1)
            return 1;

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;

        }

        return second;

    }
}