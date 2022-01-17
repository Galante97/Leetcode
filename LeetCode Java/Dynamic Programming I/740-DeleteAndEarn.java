/*
 * 740. Delete and Earn
 * You are given an integer array nums. You want to maximize the number of
 * points you get by performing the following operation any number of times:
 * 
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must
 * delete every element equal to nums[i] - 1 and every element equal to nums[i]
 * + 1.
 * Return the maximum number of points you can earn by applying the above
 * operation some number of times.
 * 
 * 
 */

 class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0)
            return 0;
        int max = 0;
        // find the max value
        for (int num : nums) {
            max = Math.max(num, max);
        }
        // all ones scenario
        if (max == 1)
            return nums.length;

        // freq array of every possible value
        int[] dp = new int[max + 1];

        for (int num : nums) {
            dp[num] += num; // index number * apperance amount
        }

        dp[dp.length - 2] = Math.max(dp[dp.length - 2], dp[dp.length - 1]);

        for (int i = dp.length - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], dp[i] + dp[i + 2]);

        }

        return dp[0];

    }

}