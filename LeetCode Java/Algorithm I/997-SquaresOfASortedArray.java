/*
 * 977. Squares of a Sorted Array
 * Given an integer array nums sorted in non-decreasing order, return an array
 * of the squares of each number sorted in non-decreasing order.
 * 
 * Example 1:
    * Input: nums = [-4,-1,0,3,10]
    * Output: [0,1,9,16,100]
    * Explanation: After squaring, the array becomes [16,1,0,9,100].
    * After sorting, it becomes [0,1,9,16,100].
 */
class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;

        for (int i = n - 1; i >= 0; i--) { // reverse loop
            int square;
            // first scenerio would be comparing most postive and most negative numbers
            // will add the biggest (abs) and square it
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square = nums[right];
                right--;
            } else {
                square = nums[left];
                left++;
            }
            result[i] = square * square;
        }
        return result;
    }
}