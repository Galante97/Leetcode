//198. House Robber

public class Solution {
    public int Rob(int[] nums) {
        if(nums == null || nums.Length == 0)
        {
            return 0;
        }
        
        int firstPrev = 0;
        int secondPrev = 0;
        int current = 0;
                        
        for(int i = 0; i < nums.Length; i++)
        {
            secondPrev = firstPrev;
            firstPrev = current;
            current = Math.Max(firstPrev, secondPrev + nums[i]);
        }
        
        return current;
    }
}