/*
 * 45. Jump Game II
 * Given an array of non-negative integers nums, you are initially positioned at
 * the first index of the array.
 * Each element in the array represents your maximum jump length at that
 * position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * You can assume that you can always reach the last index.
 * 
 * Example 1:
    * Input: nums = [2,3,1,1,4]
    * Output: 2
    * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1
    * step from index 0 to 1, then 3 steps to the last index.
 */
class Solution {
    // Time Complexity: O(N)
    // Space Complexity: O(1)
    public int jump(int[] nums) {
        int jumps = 0;
        int currentJumpEnd = 0;
        int farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // we continuously find the how far we can reach in the current jump
            farthest = Math.max(farthest, i + nums[i]);
            System.out.println(farthest);
            // if we have come to the end of the current jump,
            // we need to make another jump
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }
}