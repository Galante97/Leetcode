/*
 * 283. Move Zeroes
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
class Solution {
    // Space Complexity : O(1). Only constant space is used.
    // Time Complexity: O(n)
    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        int p1 = 0;
        int p2 = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[p1] == 0 && nums[p2] != 0) {
                // swap
                nums[p1] = nums[p2];
                nums[p2] = 0;
                p1++;
            } else if (nums[p1] != 0 && nums[p2] == 0 || nums[p1] != 0 && nums[p2] != 0) {
                p1++;
            }

            p2++;
            // reach the end
            if (p2 >= nums.length) {
                break;
            }

        }
    }
}