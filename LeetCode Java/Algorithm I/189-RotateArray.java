/*
 * 189. Rotate Array
 * Given an array, rotate the array to the right by k steps, where k is
 * non-negative.
 * 
 * Example 1:
    * Input: nums = [1,2,3,4,5,6,7], k = 3
    * Output: [5,6,7,1,2,3,4]
    * Explanation:
    * rotate 1 steps to the right: [7,1,2,3,4,5,6]
    * rotate 2 steps to the right: [6,7,1,2,3,4,5]
    * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 */
class Solution {
    // Time complexity: O(n). One pass is used to put the numbers in the new array.
    // And another pass to copy the new array to the original one.
    // Space complexity: O(n). Another array of the same size is used.
    public void rotate(int[] nums, int k) {
        // second pointer starting point
        var p = nums.length - (k % nums.length);

        // second array to hold
        int[] a = new int[nums.length];

        // shift and save to A O(n)
        for (int i = 0; i < nums.length; i++) {
            if (p >= nums.length) {
                p = 0;
            }
            a[i] = nums[p];
            p++;

        }

        // copy to nums O(n)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}