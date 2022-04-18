/*
 * https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
 * 1523. Count Odd Numbers in an Interval Range
 * Given two non-negative integers low and high. Return the count of odd numbers
 * between low and high (inclusive).
 * 
 * Example 1:
    * Input: low = 3, high = 7
    * Output: 3
    * Explanation: The odd numbers between 3 and 7 are [3,5,7].
 * Example 2:
    * Input: low = 8, high = 10
    * Output: 1
    * Explanation: The odd numbers between 8 and 10 are [9].
 * 
 */

 class Solution {
    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0) { // even
            return (high - low) / 2;
        } else {
            int diff = (high - low) / 2;
            return diff + 1;
        }
    }
}