/*
 * 746. Min Cost Climbing Stairs
 * You are given an integer array cost where cost[i] is the cost of ith step on
 * a staircase. Once you pay the cost, you can either climb one or two steps.
 * 
 * You can either start from the step with index 0, or the step with index 1.
 * Return the minimum cost to reach the top of the floor.
 * Example 1:
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        // The array's length should be 1 longer than the length of cost
        // This is because we can treat the "top floor" as a step to reach
        int[] mins = new int[cost.length + 1];

        // Start iteration from step 2, since the minimum cost of reaching
        // step 0 and step 1 is 0
        for (int i = 2; i < mins.length; i++) {
            int oneStep = mins[i - 1] + cost[i - 1];
            int twoSteps = mins[i - 2] + cost[i - 2];

            mins[i] = Math.min(oneStep, twoSteps);
        }

        // The final element in minimumCost refers to the top floor
        return mins[mins.length - 1];

    }
}