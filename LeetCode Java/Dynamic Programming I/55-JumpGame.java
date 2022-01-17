/*
 * 55. Jump Game
 * You are given an integer array nums. You are initially positioned at the
 * array's first index, and each element in the array represents your maximum
 * jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 * 
 * Example 1:
    * Input: nums = [2,3,1,1,4]
    * Output: true
    * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        boolean[] reachable = new boolean[nums.length];
        reachable[0] = true;

        for (int i = 0; i < nums.length; i++) {

            if (reachable[i] == true) {
                int j = 0;
                for (j = i + 1; j <= nums[i] + i; j++) {
                    if (j == nums.length) {
                        return true;
                    }
                    reachable[j] = true;
                }
            }
        }

        if (reachable[reachable.length - 1] == true) {
            return true;
        }
        return false;
    }
}