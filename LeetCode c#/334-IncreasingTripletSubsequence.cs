//334. Increasing Triplet Subsequence

public class Solution {
    public bool IncreasingTriplet(int[] nums) {
        int first = int.MaxValue;
        int sec = int.MaxValue;
        
        foreach (int n in nums) {
            if (n <= first) {
                first = n;
            } else if (n <= sec) {
                sec = n;
            } else {
                return true;
            }
            
        }
        
        return false;
    }
}