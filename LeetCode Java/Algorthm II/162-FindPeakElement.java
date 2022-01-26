/*
 * 162. Find Peak Element
 * A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array nums, find a peak element, and return its index. If
 * the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * You must write an algorithm that runs in O(log n) time.
 * Example 1:
    * Input: nums = [1,2,3,1]
    * Output: 2
    * Explanation: 3 is a peak element and your function should return the index
    * number 2.
 */
class Solution {
    // O(LogN)
    // O(LogN)
    public int findPeakElement(int[] nums) {
        return BinarySearch(nums, 0, nums.length - 1);
    }

    public int BinarySearch(int[] nums, int start, int end) {
        // peak element is found when the search space is reduced to only one
        if (start == end) {
            return start;
        }
        int pivot = (start + end) / 2;
        /*
         * If this element happens to be lying in a descending sequence of numbers. or a
         * local falling slope(found by comparing nums[i] to its right neighbour), it
         * means that the peak will always lie towards the left of this element. Thus,
         * we reduce the search space to the left of midmid(including itself) and
         * perform the same process on left subarray.
         */
        if (nums[pivot] > nums[pivot + 1]) {
            return BinarySearch(nums, start, pivot);
        } else {
            /*
             * If the middle element, midmid lies in an ascending sequence of numbers, or a
             * rising slope(found by comparing nums[i]nums[i] to its right neighbour), it
             * obviously implies that the peak lies towards the right of this element. Thus,
             * we reduce the search space to the right of midmid and perform the same
             * process on the right subarray.
             */
            return BinarySearch(nums, pivot + 1, end);
        }
    }
}