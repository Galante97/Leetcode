//326. Power of Three

public class Solution {
    public bool IsPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}