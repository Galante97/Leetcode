/*
 * 5 - Max Multiple
 * Given a divisor and a bound, find the largest integer N such that:
 * 
 * N is divisible by divisor.
 * N is less than or equal to bound.
 * N is greater than 0.
 * It is guaranteed that such a number exists.
 * 
 * 
 */
int solution(int divisor, int bound) {
    int n = bound;
    
    while (n >= 0) {
        if (n % divisor == 0) {
            return n;
        }
        n--;
    }
    
    return n;
    
}
