//70. Climbing Stairs

public class Solution {
    public int ClimbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int prevFib = 1;
        int currFib = 2;
        for (int i = 2; i < n; i++) {
            
            int temp = currFib;
            currFib += prevFib;
            prevFib = temp;
        
        }
        
        return currFib;
    } 
}