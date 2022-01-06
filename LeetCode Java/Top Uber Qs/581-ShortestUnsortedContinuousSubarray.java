/*
 * 581. Shortest Unsorted Continuous Subarray
 * Given an integer array nums, you need to find one continuous subarray that if
 * you only sort this subarray in ascending order, then the whole array will be
 * sorted in ascending order.
 * 
 * Return the shortest such subarray and output its length.
 * Example 1:
    * Input: nums = [2,6,4,8,10,9,15]
    * Output: 5
    * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the
    * whole array sorted in ascending order.
 */
class Solution {
    // Time complexity : O(nlogn). Sorting takes n\log nnlogn time.
    // Space complexity : O(n). We are making copy of original array.
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int start = sorted.length;
        int end = 0;

        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != nums[i]) {
                start = Math.min(start, i); // lowest index
                end = Math.max(end, i); // highest index

            }
        }
        // end index - start index + 1
        return (end - start >= 0 ? end - start + 1 : 0);
    }
}