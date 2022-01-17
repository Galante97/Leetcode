/*
 * 213. House Robber II
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have a security system connected, and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * Example 1:
    * Input: nums = [2,3,2]
    * Output: 3
    * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money =
    * 2), because they are adjacent houses.
 */
class Solution {
    // Time complexity : O(N)
    // Space complexity : O(1)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 0 to n - 1
        int s1 = robHelper(Arrays.copyOfRange(nums, 0, nums.length - 1));
        // or
        // 1 to n
        int s2 = robHelper(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(s1, s2);
    }

    public int robHelper(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0]; // max amount of money to rob 1 house
        dp[1] = Math.max(arr[0], arr[1]); // max of the first 2

        for (int i = 2; i < dp.length; i++) {
            // max amount of current house + 2 houses ago || 1 house ago
            dp[i] = Math.max(arr[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[dp.length - 1];
    }
}