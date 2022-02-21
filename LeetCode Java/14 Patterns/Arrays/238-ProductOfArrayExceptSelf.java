/*
 * 238. Product of Array Except Self
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * Example 1:
    * Input: nums = [1,2,3,4]
    * Output: [24,12,8,6]
 */

 class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prodLeft = new int[nums.length];
        int[] prodRight = new int[nums.length];

        prodLeft[0] = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            prodLeft[i + 1] = prodLeft[i] * nums[i];
        }

        prodRight[nums.length - 1] = 1;
        for (int j = nums.length - 1; j >= 1; j--) {
            prodRight[j - 1] = prodRight[j] * nums[j];
        }

        for (int i = 0; i < nums.length; i++) {
            prodLeft[i] = prodLeft[i] * prodRight[i];
        }

        return prodLeft;

    }
}