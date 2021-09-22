//53. Maximum Subarray

public class Solution {
    public int MaxSubArray(int[] nums) {
        // Initialize our variables using the first element.
        int currSubArr = nums[0];
        int maxSubArr = nums[0];
        
        // Start with the 2nd element since we already used the first one.
        for (int i = 1; i < nums.Length; i++) {
            int num = nums[i];
            // If current_subarray is negative, throw it away. Otherwise, keep adding to it.
            currSubArr = Math.Max(num, currSubArr + num);
            maxSubArr = Math.Max(maxSubArr, currSubArr);
        }
        
        return maxSubArr;
    }
}