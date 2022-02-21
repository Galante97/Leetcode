/*
 * 704. Binary Search
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 */
class Solution {
    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int pivot = start + (end - start) / 2;

            if (nums[pivot] == target) {
                return pivot;

            } else if (target < nums[pivot]) {
                end = pivot - 1;

            } else if (target > nums[pivot]) {
                start = pivot + 1;
            }

        }

        return -1;

    }
}