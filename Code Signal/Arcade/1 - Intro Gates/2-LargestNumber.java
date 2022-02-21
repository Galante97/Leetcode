/*
 * 2 - Largest Number
 * Given an integer n, return the largest number that contains exactly n digits.
 * 
 * Example
 * 
 * For n = 2, the output should be
 * solution(n) = 99.
 */

int solution(int n) {
    return (int)Math.pow(10,n) - 1;
}
