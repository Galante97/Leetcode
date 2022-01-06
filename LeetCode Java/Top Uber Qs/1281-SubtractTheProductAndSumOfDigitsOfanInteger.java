/*
 * 1281. Subtract the Product and Sum of Digits of an Integer
 * Given an integer number n, return the difference between the product of its
 * digits and the sum of its digits.
 * 
 * Example 1:
    * Input: n = 234
    * Output: 15
    * Explanation:
    * Product of digits = 2 * 3 * 4 = 24
    * Sum of digits = 2 + 3 + 4 = 9
    * Result = 24 - 9 = 15
 */
class Solution {
    // O(N)
    // O(1)
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        while (n > 0) {
            // n will be 234 -> 23 -> 2
            sum += n % 10;
            product *= n % 10;
            n /= 10;
        }

        return product - sum;

    }
}