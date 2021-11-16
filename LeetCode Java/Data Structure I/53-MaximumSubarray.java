/*
53. Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array.

Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.
   
Example 2:
    Input: nums = [1]
    Output: 1

Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
*/

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        
        int currSub = nums[0];
        int maxSub = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            int num = nums[i];

            currSub = Math.max(num, currSub + num); 
            maxSub = Math.max(maxSub, currSub); 
            
            
        }
        
        return maxSub;
    }
    
    //O(N) runtime
}