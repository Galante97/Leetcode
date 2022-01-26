/*
 * 33. Search in Rotated Sorted Array
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k (1 <= k < nums.length) such that the resulting array is
 * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
 * and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 */
class Solution {
    // O(logN)
    // O(1)
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {  return -1;  }
        int left = 0;
        int right = nums.length - 1;
        // B.S. to find smallest element as left
        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int start = left;
        int tail = 0;
        int head = nums.length - 1;
        // which side of the pivoted values do we want to B.S.
        if (target >= nums[start] && target <= nums[head]) {
            tail = start;
        } else {
            head = start;
        }
        // normal binary search
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