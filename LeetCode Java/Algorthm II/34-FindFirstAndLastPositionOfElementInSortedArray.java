/*
 * 34. Find First and Last Position of Element in Sorted Array
 * Given an array of integers nums sorted in non-decreasing order, find the
 * starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 * Example 1:
    * Input: nums = [5,7,7,8,8,10], target = 8
    * Output: [3,4]
 */
class Solution {
    // O(logN)
    // O(1)
    public int[] searchRange(int[] nums, int target) {
        int tail = 0;
        int head = nums.length - 1;
        // find intial mid point
        int pivotPoint = findTarget(nums, tail, head, target);
        if (pivotPoint == -1) {
            return new int[] { -1, -1 };
        }
        int start = pivotPoint;
        int end = pivotPoint;
        // find the lowest target index
        int rangeLower = 0;
        while (start != -1) {
            rangeLower = start;
            start = findTarget(nums, tail, start - 1, target);
        }
        // find the highest target index
        int rangeHigher = 0;
        while (end != -1) {
            rangeHigher = end;
            end = findTarget(nums, end + 1, head, target);
        }
        return new int[] { rangeLower, rangeHigher };
    }

    // Binary search
    public int findTarget(int[] nums, int tail, int head, int target) {
        while (tail <= head) {
            int pivot = (tail + head) / 2;
            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] < target) {
                tail = pivot + 1;
            } else if (nums[pivot] > target) {
                head = pivot - 1;
            }
        }
        return -1;
    }
}