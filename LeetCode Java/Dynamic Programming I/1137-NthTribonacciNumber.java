/*
 * 1137. N-th Tribonacci Number
 * The Tribonacci sequence Tn is defined as follows:
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * 
 * Given n, return the value of Tn.
 * Example 1:
    * Input: n = 4
    * Output: 4
    * Explanation:
    * T_3 = 0 + 1 + 1 = 2
    * T_4 = 1 + 1 + 2 = 4
 */
 class Solution {
    // O(N)
    // O(1)
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        int first = 0;
        int second = 1;
        int third = 1;

        for (int i = 2; i < n; i++) {
            int temp = third;
            third += first;
            third += second;
            first = second;
            second = temp;
        }
        return third;
    }
}