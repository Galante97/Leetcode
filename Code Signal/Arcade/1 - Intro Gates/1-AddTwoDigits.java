/*
 * 1. Add two digits
 * You are given a two-digit integer n. Return the sum of its digits.
 * Example
 * For n = 29, the output should be
 * solution(n) = 11.
 */
int solution(int n) {
    int out = 0;
    while (n > 0) {
        out += n % 10;
        n = Math.floorDiv(n, 10);
    }
    
    return out;
}
