/*
334. Increasing Triplet Subsequence

Given an integer array nums, return true if there exists a triple of indices (i, j, k)
such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.

Example 1:
    Input: nums = [1,2,3,4,5]
    Output: true
    Explanation: Any triplet where i < j < k is valid.
*/

class Solution {
    // Time complexity : O(N) where NN is the size of nums. We are updating first_num and second_num as we are scanning nums.
    // Space complexity : O(1) since we are not consuming additional space other than variables for two numbers.
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int sec = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= sec) {
                sec = num;
            } else {
                return true;
            }
            
        }
        
        return false;
    }
}